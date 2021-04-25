package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.element.Fire;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Charge;

import java.awt.*;
import java.util.ArrayList;

public class Rotom extends Engimon {

    public Rotom(int level, Point position) {
        id = 7;
        species = "Rotom";
        name = "Rotom";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Fire());
        elements.add(new Electric());
        skills = new ArrayList<>();
        skills.add(new Charge(false));
        life = 1;
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/rotom.png";
        }
        return "resources/sprites/pokemon/rotom 2.png";
    }

    public String interact() {
        return "Rotom~";
    }
}
