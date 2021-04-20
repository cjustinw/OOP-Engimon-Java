/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.model.engimon;

import com.engimon.model.engimon.species.*;
import java.awt.Point;

/**
 *
 * @author chris
 */
public class CreateEngimon {

    public Engimon createEngimon(int id, int lvl, Point pos) {
        return switch (id) {
            case 1 -> new Charmander(lvl, pos);
            case 2 -> new Entei(lvl, pos);
            case 3 -> new Pikachu(lvl, pos);
            case 4 -> new Raikou(lvl, pos);
            case 5 -> new Diglet(lvl, pos);
            case 6 -> new Groudon(lvl, pos);
            case 7 -> new Rotom(lvl, pos);
            case 8 -> new Squirtle(lvl, pos);
            case 9 -> new Gyarados(lvl, pos);
            case 10 -> new Glaceon(lvl, pos);
            case 11 -> new Articuno(lvl, pos);
            case 12 -> new Lapras(lvl, pos);
            case 13 -> new Swampert(lvl, pos);
            default -> null;
        };
    }
}
