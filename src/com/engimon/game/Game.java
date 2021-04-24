/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.model.engimon.WildEngimon;
import com.engimon.model.engimon.CreateEngimon;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.engimon.species.*;
import com.engimon.model.map.CellType;
import com.engimon.model.map.MapBoard;
import com.engimon.model.player.Player;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris
 */
public class Game {
    private final Player player;
    private final MapBoard map;
    private final List<WildEngimon> wildEngimon;
    
    private static int SIZE_LENGTH = 20;
    private static int SIZE_WIDTH = 20;
    
    
    /* Movement */
    private String prevMove = " ";
    private String currentMove = " ";
    private int moveCounter = 1;
    
    public Game() {
        map = new MapBoard();
        player = new Player(new Point(16,11));
        wildEngimon = new ArrayList<>();
        player.addEngimon(new Raikou(6, new Point(16,10)));
        player.addEngimon(new Charmander(6, new Point(-1,-1)));
        player.setActiveEngimon(player.getEngimonAtIndex(0));
        map.at(player.getPosition()).setObject(player);
        map.at(player.getActiveEngimon().getPosition()).setObject(player.getActiveEngimon());
        initWildEngimon(16);
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public MapBoard getMap() {
        return map;
    }
    
    public List<WildEngimon> getWildEngimon() {
        return wildEngimon;
    }
    
    private void initWildEngimon(int n) {
        WildEngimon engimon;
        Random rand = new Random();
        CreateEngimon create = new CreateEngimon();
        for(int i = 0; i < n; i++) {
            Point pos;
            do{
                pos = new Point(rand.getRandomNumber(0, SIZE_LENGTH-1), rand.getRandomNumber(0, SIZE_WIDTH-1));
            } while(!map.isPositionValid(pos) || map.at(pos).isFull() || map.at(pos).getType().equals(CellType.ROCK_STAIR));
            
            int lvl = rand.getRandomNumber(1, 6);
            
            int id;
       
            switch (map.at(pos).getType()) {
                case GRASSLAND, GRASSLAND_STREET -> id = rand.getRandomNumber(3, 7);
                case MOUNTAINS, MOUNTAINS_BORDER -> id = rand.getRandomNumber(1, 2);
                case SEA, SEA_BORDER -> {
                    do{
                        id = rand.getRandomNumber(8, 13);
                    } while(id == 10 || id == 11);
                }
                default ->      id = rand.getRandomNumber(10, 11);
            }
            
            engimon = new WildEngimon(create.createEngimon(id, lvl, pos), map, rand.getRandomNumber(900, 1100));
            wildEngimon.add(engimon);
            map.at(engimon.getPosition()).setObject(engimon.getEngimon());
        }
        
        for(int i = 0; i < wildEngimon.size(); i++){
            new Thread(wildEngimon.get(i)).start();
        }
    }
 
    public void playerMovement(String direction) {
        int xtmp = player.getPosition().x;
        int ytmp = player.getPosition().y;
        boolean move = true;
        if(!prevMove.equals(currentMove)){
            moveCounter = 1;
        }
        prevMove = currentMove;
        player.setImagePath(direction, moveCounter%2);
        switch(direction){
            case "U" -> {
                ytmp = ytmp - 1;
                currentMove = direction;
                moveCounter++;
            }
            case "D" -> {
                ytmp = ytmp + 1;
                currentMove = direction;
                moveCounter++;
            }
            case "L" -> {
                xtmp = xtmp - 1;
                currentMove = direction;
                moveCounter++;
            }
            case "R" -> {
                xtmp = xtmp + 1;
                currentMove = direction;
                moveCounter++;
            }
            case " " -> move = false;
        }
        
        if(!playerCollisions(xtmp, ytmp) && move){
            map.at(player.getActiveEngimon().getPosition()).setObject(null);
            player.getActiveEngimon().setPosition(player.getPosition());
            map.at(player.getActiveEngimon().getPosition()).setObject(player.getActiveEngimon());
            player.setPosition(new Point(xtmp, ytmp));
            map.at(player.getPosition()).setObject(player);
            map.printMap();
        }
    }
    
    private boolean playerCollisions(int xtmp, int ytmp) {
        if((xtmp < 0) || (xtmp > SIZE_WIDTH - 1) || (ytmp < 0) || (ytmp > SIZE_LENGTH - 1)){
            return true;
        }
        else if(map.at(xtmp, ytmp).isFull() && (map.at(xtmp, ytmp).getObject() != player.getActiveEngimon())){
            return true;
        }
        else if(map.at(xtmp,ytmp).getType().equals(CellType.ROCK_WALL)) {
            return true;
        }
        else if(map.at(xtmp, ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && currentMove.equals("L")){
            return true;
        }
        else if(xtmp - 1 > 0){
            if(map.at(xtmp-1, ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && currentMove.equals("R")){
                return true;
            }
        }
        return false;
    }
}
