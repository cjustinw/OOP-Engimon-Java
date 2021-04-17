package com.engimon.model.engimon.species;

import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Gyarados extends Engimon {

    public Gyarados(String name, int level, Point position) {
        id = 9;
        species = "Gyarados";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Water());
//        skills.add(new OceanicOperetta());
    }

    public String interact() {
        return "Rrrrroooooo~";
    }
}
