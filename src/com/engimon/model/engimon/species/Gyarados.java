package com.engimon.model.engimon.species;

import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.OceanicOperetta;

import java.awt.*;
import java.util.ArrayList;

public class Gyarados extends Engimon {

    public Gyarados(int level, Point position) {
        id = 9;
        species = "Gyarados";
        name = "Gyarados";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Water());
        skills = new ArrayList<>();
        skills.add(new OceanicOperetta(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Rrrrroooooo~";
    }
}
