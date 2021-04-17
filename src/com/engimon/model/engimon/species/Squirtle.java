package com.engimon.model.engimon.species;

import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Squirtle extends Engimon {

    public Squirtle(String name, int level, Point position) {
        id = 8;
        species = "Squirtle";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Water());
//        skills.add(new WaterGun());
    }

    public String interact() {
        return "Squirtle~";
    }
}
