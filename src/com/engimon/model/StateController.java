package com.engimon.model;

import com.engimon.model.Engimon.*;
//import com.engimon.model.Engimon.Entei;
import com.engimon.model.map.MapBoard;

import java.util.ArrayList;
import java.util.Random;

public class StateController extends Thread{
    private ArrayList<Engimon> wildEngimons;
    private MapBoard map;
//    private Player player

    @Override
    public void run() {
        map = new MapBoard();

        for(int i = 0; i < 10 ; i++) {
            spawnWildEngimon();
        }
    }

    public void spawnWildEngimon() {
        Random random = new Random();
        int x = random.nextInt() % map.getSizeWidth();
        int y = random.nextInt() % map.getSizeLength();
        if (map.at(x,y).isEmpty()) {
            Engimon engimon = new Entei();
            if ()
            map.spawnEngimonAt(engimon, x, y);
        } else {
            this.spawnWildEngimon();
        }
    }


}
