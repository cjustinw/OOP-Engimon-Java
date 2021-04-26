/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.loader.GameLoader;
import com.engimon.model.engimon.CreateEngimon;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.engimon.WildEngimon;
import com.engimon.model.engimon.species.Raikou;
import com.engimon.model.map.CellType;
import static com.engimon.model.map.CellType.GRASSLAND_STREET;
import static com.engimon.model.map.CellType.MOUNTAINS_BORDER;
import static com.engimon.model.map.CellType.SEA_BORDER;
import com.engimon.model.map.MapBoard;
import com.engimon.model.player.Player;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Engimon.cpp
 */
public class Game {
    private final Player player;
    private final MapBoard map;
    private final List<WildEngimon> wildEngimon;
    
    private Engimon currentWildEngimon;
    
    private static int SIZE_LENGTH = 20;
    private static int SIZE_WIDTH = 20;
    
    public enum State {
        RUNNING, BATTLE,PAUSED
    }
    
    private State gameState;
    
    /* Movement */
    private String prevMove = " ";
    private String currentMove = " ";
    private int moveCounter = 1;
    
    public Game() {
        gameState = State.RUNNING;
        map = new MapBoard();
        player = new Player(new Point(16,11));
        wildEngimon = new ArrayList<>();
        currentWildEngimon = null;
        player.addEngimon(new Raikou(6, new Point(16,10)));
        player.setActiveEngimon(player.getEngimonAtIndex(0));
        map.at(player.getPosition()).setObject(player);
        map.at(player.getActiveEngimon().getPosition()).setObject(player.getActiveEngimon());
        initWildEngimon(20);
    }
    
    public State getState() {
        return gameState;
    }
    
    public void setState(State state){
        gameState = state;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public MapBoard getMap() {
        return map;
    }
    
    public Engimon getCurrentWildEngimon() {
        return currentWildEngimon;
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
            
            engimon = new WildEngimon(create.createEngimon(id, lvl, pos), map, rand.getRandomNumber(900, 1100), wildEngimon);
            wildEngimon.add(engimon);
            map.at(engimon.getPosition()).setObject(engimon.getEngimon());
        }
        
        for(int i = 0; i < wildEngimon.size(); i++){
            new Thread(wildEngimon.get(i)).start();
        }
    }
    
    public void pauseWildEngimonMovement(boolean pause){
        for(int i = 0; i < wildEngimon.size(); i++){
            wildEngimon.get(i).setPaused(pause);
        }
    }
    
    public void spawnRandomWildEngimon() {
        pauseWildEngimonMovement(true);
        WildEngimon engimon;
        Random rand = new Random();
        CreateEngimon create = new CreateEngimon();
        Point pos;
        do{
            pos = new Point(rand.getRandomNumber(0, SIZE_LENGTH-1), rand.getRandomNumber(0, SIZE_WIDTH-1));
        } while(!map.isPositionValid(pos) || map.at(pos).isFull() || map.at(pos).getType().equals(CellType.ROCK_STAIR));
            
        int lvl = rand.getRandomNumber(player.getHighestLevelEngimon(), player.getHighestLevelEngimon() + 3);
            
        int id;
       
        switch (map.at(pos).getType()) {
            case GRASSLAND, GRASSLAND_STREET -> id = rand.getRandomNumber(3, 7);
            case MOUNTAINS, MOUNTAINS_BORDER -> id = rand.getRandomNumber(1, 2);
            case SEA, SEA_BORDER -> {
                do{
                    id = rand.getRandomNumber(8, 13);
                } while(id == 10 || id == 11);
            }
            default -> id = rand.getRandomNumber(10, 11);
        }
            
        engimon = new WildEngimon(create.createEngimon(id, lvl, pos), map, rand.getRandomNumber(900, 1100), wildEngimon);
        wildEngimon.add(engimon);
        map.at(engimon.getPosition()).setObject(engimon.getEngimon());
        new Thread(engimon).start();
        pauseWildEngimonMovement(false);
    }
    
    public int getNumOfWildEngimon() {
        return wildEngimon.size();
    }
    
    public boolean isWildEngimonLessThanBefore() {
        return wildEngimon.size() < 20;
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
        
        if(!playerCollisions(xtmp, ytmp) && move && player.getActiveEngimon() != null){
            map.at(player.getActiveEngimon().getPosition()).setObject(null);
            player.getActiveEngimon().setPosition(player.getPosition());
            map.at(player.getActiveEngimon().getPosition()).setObject(player.getActiveEngimon());
            player.setPosition(new Point(xtmp, ytmp));
            map.at(player.getPosition()).setObject(player);
        }
    }
    
    private boolean playerCollisions(int xtmp, int ytmp) {
        if((xtmp < 0) || (xtmp > SIZE_WIDTH - 1) || (ytmp < 0) || (ytmp > SIZE_LENGTH - 1)){
            return true;
        }
        else if(map.at(xtmp, ytmp).isFull() && (map.at(xtmp, ytmp).getObject() != player.getActiveEngimon())){
            if(map.at(xtmp, ytmp).getObject().isEngimon() && player.getActiveEngimon() != null){
                pauseWildEngimonMovement(true);
                currentWildEngimon = map.at(xtmp, ytmp).getObject().getEngimonAtCell();
                gameState = State.BATTLE;
            }
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
    
    public List<String> battle() {
        /* Masukkan engimon ke Inventory player */
        
        List<String> output = new ArrayList<>();
        
        if(player.getActiveEngimon().getLife() > 0) {
            
        }
        
        double activePower = player.getActiveEngimon().getPower(currentWildEngimon);
        double wildPower = currentWildEngimon.getPower(player.getActiveEngimon());
        
        if(activePower >= wildPower) {
            output.add(player.getActiveEngimon().getName() + " Win!");
            if(player.getActiveEngimon().isMaxCumulativeExp()){
                map.at(player.getActiveEngimon().getPosition()).setObject(null);
                player.removeEngimon(player.getActiveEngimon());
                player.setActiveEngimon(null);
            }
            if(player.getActiveEngimon() != null) {
                if(player.getActiveEngimon().addExp(100*currentWildEngimon.getLevel())){
                // output.add(    );
                }
            }
            for(int i = 0; i < wildEngimon.size(); i++){
                if(wildEngimon.get(i).getEngimon() == currentWildEngimon){
                    wildEngimon.remove(i);
                    map.at(currentWildEngimon.getPosition()).setObject(null);
                    break;
                }
            }
            if(!player.isInventoryFull()){
                player.addEngimon(currentWildEngimon);
                output.add(currentWildEngimon.getName() + " will be added to your Inventory!");
            }
            else{
                output.add("Your Inventory is full!");
            }
            if(!player.isInventoryFull()){
                player.addSkillItem(currentWildEngimon.getSkills().get(0));
                output.add(currentWildEngimon.getSkills().get(0).getSkillName() + " will be added to your Inventory!");
            }
            else{
                output.add("Your Inventory is full!");
            }
        }
        else {
            output.add(currentWildEngimon.getName() + " Win!");
            player.getActiveEngimon().reduceLife();
            if(player.getActiveEngimon().getLife() > 0) {
                output.add(player.getActiveEngimon().getName() + "'s life remains " + player.getActiveEngimon().getLife());
            }
            else{
                output.add(player.getActiveEngimon().getName() + " will be removed from your Inventory!");
                map.at(player.getActiveEngimon().getPosition()).setObject(null);
                player.removeEngimon(player.getActiveEngimon());
                player.setActiveEngimon(null);
            }
        }
        return output;
    }

    public void save() {
        pauseWildEngimonMovement(true);

        // isi save
        GameLoader gl = new GameLoader(player);

        try {
            gl.save(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

        pauseWildEngimonMovement(false);
    }

    public void load() throws IOException {

        GameLoader gl = new GameLoader(player);

        gl.load();

        int countWild = Integer.parseInt(gl.loadLine());

        for (int i = 0; i < countWild; i++) {
            Engimon engimon = gl.loadEngimon();
            int speed = Integer.parseInt(gl.loadLine());
            wildEngimon.add(new WildEngimon(engimon, map, speed, wildEngimon));
        }
    }
    
    public List<WildEngimon> getWildEngimons() {
        return wildEngimon;
    }
}
