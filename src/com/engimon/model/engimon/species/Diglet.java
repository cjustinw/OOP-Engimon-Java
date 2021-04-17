package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Diglet extends Engimon {

    public Diglet(String name, int level, Point position) {
        id = 5;
        species = "Diglet";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Ground());
//        skills.add(new Dig());
    }

    public String interact() {
        return "Didididi~ Diglet";
    }
}
