package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.element.Fire;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Rotom extends Engimon {

    public Rotom(String name, int level, Point position) {
        id = 7;
        species = "Rotom";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Fire());
        elements.add(new Electric());
//        skills.add(new Charge());
    }

    public String interact() {
        return "Rotom~";
    }
}
