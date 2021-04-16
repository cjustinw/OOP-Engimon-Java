package com.engimon.model;

import com.engimon.model.Engimon.*;
import com.engimon.model.map.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StateController extends Thread{
    private ArrayList<Engimon> wildEngimons;
    private MapBoard map;
//    private Player player
    private static final int MOVE_CHOICE = 4;

    @Override
    public void run() {
        map = new MapBoard();
        wildEngimons = new ArrayList<>();

        for(int i = 0; i < 10 ; i++) {
            spawnWildEngimon();
        }

        int i = 0;
        while (i < 10) {
            try {
                map.print();
                sleep(2000);
                System.out.println(i);
                moveAllWildEngimon();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void spawnWildEngimon() {
        Random random = new Random();
        int x = random.nextInt(map.getSizeWidth()) + 1;
        int y = random.nextInt(map.getSizeLength()) + 1;
        System.out.println(x + " " + y);
        if (map.at(x,y).isEmpty()) {
            Engimon engimon = new Entei();
            if (engimon.isAllowedTo(map.at(x,y))) {
                engimon.setPosition(new Point(x,y));
                wildEngimons.add(engimon);
                map.spawnEngimonAt(engimon, x, y);
            } else {
                this.spawnWildEngimon();
            }
        } else {
            this.spawnWildEngimon();
        }
    }

    public void moveWildEngimon(int idx) throws IndexOutOfBoundsException {
        if (idx > wildEngimons.size() || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        Point source = wildEngimons.get(idx).getPosition(); Point target;
//        System.out.println(source.getX() + " " + source.getY());  // debug
        do {
            target = new Point(source);
            int rand = (new Random()).nextInt(MOVE_CHOICE) + 1;
            switch (rand) {
                case 0 -> target.addX(); // kanan
                case 1 -> target.subX(); // kiri
                case 2 -> target.addY(); // atas
                case 3 -> target.subY(); // bawah
            }
//            System.out.println(target.getX() + " " + target.getY());  // debug
        }
        while( ! (map.isPositionValid(target)
                && map.at(target).isEmpty()
                && wildEngimons.get(idx).isAllowedTo(map.at(target))) ) ;
        map.at(source).moveObjectTo(map.at(target));
        wildEngimons.get(idx).setPosition(target);
    }

    public void moveAllWildEngimon() {
        for (int i = 0; i < wildEngimons.size(); i++) {
            moveWildEngimon(i);
        }
    }
}
