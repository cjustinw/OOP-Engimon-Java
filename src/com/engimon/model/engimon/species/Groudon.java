package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Earthquake;

import java.awt.*;
import java.util.ArrayList;

public class Groudon extends Engimon {

    public Groudon(int level, Point position) {
        id = 6;
        species = "Groudon";
        name = "Groudon";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Ground());
        skills = new ArrayList<>();
        skills.add(new Earthquake(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Rrrrraaaaaaa~";
    }
}
