/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.model.engimon;

import com.engimon.game.Random;
import com.engimon.model.element.Element.ElmtType;
import com.engimon.model.map.CellType;
import com.engimon.model.map.MapBoard;

import java.awt.Point;
import java.util.List;

/**
 *
 * @author Engimon.cpp
 */
public class WildEngimon implements Runnable{
    private static int SIZE_LENGTH = 20;
    private static int SIZE_WIDTH = 20;
    
    private Engimon engimon;
    private MapBoard map;
    private int speed;
    private List<WildEngimon> list;
    private boolean isPaused;
    private boolean isAlive;
    
    
    private int countMove;
    
    public WildEngimon(Engimon engimon, MapBoard map, int speed, List<WildEngimon> list){
        isPaused = false;
        this.engimon = engimon;
        this.map = map;
        this.speed = speed;
        this.list = list;
        countMove = 0;
        isAlive = true;
    }
    
    public Engimon getEngimon() {
        return engimon;
    }
    
    public void setPaused(boolean pause) {
        isPaused = pause;
    }
    
    public synchronized void move() {
        if(!isPaused){
            Random rand = new Random();
            int dir;
            Point pos;
            do{
                pos = new Point(engimon.getPosition());
                dir = rand.getRandomNumber(1, 4);
                switch (dir) {
                    case 1 -> pos.y--;
                    case 2 -> pos.y++;
                    case 3 -> pos.x--;
                    default -> pos.x++;
                }
            }while(engimonCollisions(pos.x, pos.y));
            map.at(engimon.getPosition()).setObject(null);
            engimon.setPosition(pos);
            map.at(pos).setObject(engimon);
            countMove++;
        }
    }
    
    public Point getPosition() {
        return engimon.getPosition();
    }

    public int getSpeed() {
        return speed;
    }
    
    private synchronized boolean engimonCollisions(int xtmp, int ytmp) {
        if((xtmp < 0) || (xtmp > SIZE_WIDTH - 1) || (ytmp < 0) || (ytmp > SIZE_LENGTH - 1)){
            return true;
        }
        else if(map.at(xtmp, ytmp).isFull()){
            return true;
        }
        else if(map.at(xtmp,ytmp).getType().equals(CellType.ROCK_WALL)) {
            return true;
        }
        else if(map.at(xtmp, ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && (xtmp == engimon.getPosition().x-1)){
            return true;
        }
        else if(xtmp - 1 > 0){
            if(map.at(xtmp-1, ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && (xtmp == engimon.getPosition().x+1)){
                return true;
            }
        }
            if(engimon.getElements().size() == 1){
                switch (engimon.getElements().get(0).getElmt()) {
                    case FIRE -> {
                        return (!map.at(xtmp,ytmp).getType().equals(CellType.MOUNTAINS) && !map.at(xtmp,ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && !map.at(xtmp,ytmp).getType().equals(CellType.ROCK_STAIR));
                    }
                    case ELECTRIC, GROUND -> {
                        return (!map.at(xtmp,ytmp).getType().equals(CellType.GRASSLAND) && !map.at(xtmp,ytmp).getType().equals(CellType.GRASSLAND_STREET) && !map.at(xtmp,ytmp).getType().equals(CellType.ROCK_STAIR));
                    }
                    case ICE -> {
                        return (!map.at(xtmp,ytmp).getType().equals(CellType.TUNDRA));
                    }
                    case WATER -> {
                        return (!map.at(xtmp,ytmp).getType().equals(CellType.SEA) && !map.at(xtmp,ytmp).getType().equals(CellType.SEA_BORDER));
                    }
                }
            }
            else{
                if(engimon.getElements().get(0).getElmt().equals(ElmtType.FIRE) && engimon.getElements().get(1).getElmt().equals(ElmtType.ELECTRIC)){
                    return (!map.at(xtmp,ytmp).getType().equals(CellType.MOUNTAINS) && !map.at(xtmp,ytmp).getType().equals(CellType.MOUNTAINS_BORDER) && !map.at(xtmp,ytmp).getType().equals(CellType.ROCK_STAIR) && !map.at(xtmp,ytmp).getType().equals(CellType.GRASSLAND) && !map.at(xtmp,ytmp).getType().equals(CellType.GRASSLAND_STREET));
                }
                else if(engimon.getElements().get(0).getElmt().equals(ElmtType.WATER) && engimon.getElements().get(1).getElmt().equals(ElmtType.ICE)){
                    return (!map.at(xtmp,ytmp).getType().equals(CellType.SEA) && !map.at(xtmp,ytmp).getType().equals(CellType.SEA_BORDER) && !map.at(xtmp,ytmp).getType().equals(CellType.TUNDRA));
                }
                else{
                    return (!map.at(xtmp,ytmp).getType().equals(CellType.SEA) && !map.at(xtmp,ytmp).getType().equals(CellType.SEA_BORDER) && !map.at(xtmp,ytmp).getType().equals(CellType.GRASSLAND) && !map.at(xtmp,ytmp).getType().equals(CellType.GRASSLAND_STREET) && !map.at(xtmp,ytmp).getType().equals(CellType.ROCK_STAIR));
                }
            }
        return false;
    }
    
    @Override
    public void run() {
        while(isAlive) {
            move();
            if(countMove >= 3){
                if(!engimon.isMaxCumulativeExp()){
                    if(engimon.addExp(100)){
                        // do nothing
                    }
                }
                else{
                    for(int i = 0; i < list.size(); i++){
                        if(engimon == list.get(i).getEngimon()){
                            list.remove(i);
                            map.at(engimon.getPosition()).setObject(null);
                            isAlive = false;
                            break;
                        }
                    }
                }
                countMove = 0;
            }
            try{
                Thread.sleep(speed);
            } catch(InterruptedException e) {
                
            }
        }
    }
}
