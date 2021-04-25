package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Catastropika;

import java.awt.*;
import java.util.ArrayList;

public class Raikou extends Engimon {

    public Raikou(int level, Point position) {
        id = 4;
        species = "Raikou";
        name = "Raikou";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Electric());
        skills = new ArrayList<>();
        skills.add(new Catastropika(false));
        life = 1;
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/raikou.png";
        }
        return "resources/sprites/pokemon/raikou 2.png";
    }

    public String interact() {
        return "Rrrrrooowrrr~";
    }
}
