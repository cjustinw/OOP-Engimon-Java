package com.engimon.model.engimon.species;

import com.engimon.model.element.Ice;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.FreezeShock;

import java.awt.*;
import java.util.ArrayList;

public class Glaceon extends Engimon {

    public Glaceon(int level, Point position) {
        id = 10;
        species = "Glaceon";
        name = "Glaceon";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Ice());
        skills = new ArrayList<>();
        skills.add(new FreezeShock(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Glceon~";
    }
}
