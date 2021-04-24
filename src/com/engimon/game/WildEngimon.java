/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.game;

import com.engimon.model.engimon.Engimon;
import com.engimon.model.map.CellType;
import com.engimon.model.map.MapBoard;
import java.awt.Point;

/**
 *
 * @author chris
 */
public class WildEngimon implements Runnable{
    private static int SIZE_LENGTH = 20;
    private static int SIZE_WIDTH = 20;
    
    private Engimon engimon;
    private MapBoard map;
    private int speed;
    
    public WildEngimon(Engimon engimon, MapBoard map, int speed){
        this.engimon = engimon;
        this.map = map;
        this.speed = speed;
    }
    
    public Engimon getEngimon() {
        return engimon;
    }
    
    public synchronized void move() {
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
    }
    
    public Point getPosition() {
        return engimon.getPosition();
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
        return false;
    }
    
    @Override
    public void run() {
        while(true) {
            move();
            try{
                
                Thread.sleep(speed);
            } catch(InterruptedException e) {
                
            }
        }
    }
}
