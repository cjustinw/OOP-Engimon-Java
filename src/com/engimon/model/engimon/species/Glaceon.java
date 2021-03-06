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
        life = 1;
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/glaceon.png";
        }
        return "resources/sprites/pokemon/glaceon 2.png";
    }

    public String interact() {
        return "Glceon~";
    }
}
