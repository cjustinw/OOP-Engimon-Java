package com.engimon.model.engimon.species;

import com.engimon.model.element.Ice;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.FreezeShock;

import java.awt.*;

public class Glaceon extends Engimon {

    public Glaceon(int level, Point position) {
        id = 10;
        species = "Glaceon";
        name = "Glaceon";
        this.level = level;
        this.position = position;
        elements.add(new Ice());
        skills.add(new FreezeShock(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Glceon~";
    }
}
