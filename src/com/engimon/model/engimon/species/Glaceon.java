package com.engimon.model.engimon.species;

import com.engimon.model.element.Ice;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Glaceon extends Engimon {

    public Glaceon(String name, int level, Point position) {
        id = 10;
        species = "Glaceon";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Ice());
//        skills.add(new FreezeShock());
    }

    public String interact() {
        return "Glceon~";
    }
}
