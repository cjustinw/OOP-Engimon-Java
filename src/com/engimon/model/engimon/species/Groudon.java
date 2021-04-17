package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Groudon extends Engimon {

    public Groudon(String name, int level, Point position) {
        id = 6;
        species = "Groudon";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Ground());
//        skills.add(new Earthquake());
    }

    public String interact() {
        return "Rrrrraaaaaaa~";
    }
}
