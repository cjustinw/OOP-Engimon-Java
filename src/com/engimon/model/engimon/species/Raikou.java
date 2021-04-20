package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Catastropika;

import java.awt.*;

public class Raikou extends Engimon {

    public Raikou(int level, Point position) {
        id = 4;
        species = "Raikou";
        name = "Raikou";
        this.level = level;
        this.position = position;
        elements.add(new Electric());
        skills.add(new Catastropika(false));
    }

    public String interact() {
        return "Rrrrrooowrrr~";
    }
}
