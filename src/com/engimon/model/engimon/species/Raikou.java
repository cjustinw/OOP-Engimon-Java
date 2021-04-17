package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.Catastropika;

import java.awt.*;

public class Raikou extends Engimon {

    public Raikou(String name, int level, Point position) {
        id = 4;
        species = "Raikou";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Electric());
        skills.add(new Catastropika());
    }

    public String interact() {
        return "Rrrrrooowrrr~";
    }
}
