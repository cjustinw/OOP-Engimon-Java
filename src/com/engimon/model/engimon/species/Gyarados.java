package com.engimon.model.engimon.species;

import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.OceanicOperetta;

import java.awt.*;

public class Gyarados extends Engimon {

    public Gyarados(int level, Point position) {
        id = 9;
        species = "Gyarados";
        name = "Gyarados";
        this.level = level;
        this.position = position;
        elements.add(new Water());
        skills.add(new OceanicOperetta(false));
    }

    public String interact() {
        return "Rrrrroooooo~";
    }
}
