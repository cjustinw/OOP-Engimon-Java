package com.engimon.model.player;

import java.awt.Point;
import java.util.Arrays;

import com.engimon.model.engimon.species.Groudon;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1, 1);
        Point point2 = new Point(2, 1);
        Player player = new Player(point);
        Groudon groudon = new Groudon(11, point2);
        String[] engimonList = player.getAllEngimonName();
        System.out.println(Arrays.toString(engimonList));
        if (player.getPosition().equals(point)) {
            System.out.println("true 1");
        }
        if (player.isEngimon() == false) {
            System.out.println("true 2");

        }
        // System.out.println(player.getEngimonAtIndex(0));
        if (player.isInventoryFull() == false) {
            System.out.println("true 3");
        }
        player.addEngimon(groudon);
        engimonList = player.getAllEngimonName();
        System.out.println(Arrays.toString(engimonList));
        player.setActiveEngimon(groudon);
        if (player.getActiveEngimon() == groudon) {
            System.out.println("true 4");
        }
        if (player.getActiveEngimonIndex() == 0) {
            System.out.println("true 5");
        }
    }
}