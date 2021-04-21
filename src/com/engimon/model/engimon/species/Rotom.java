package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.element.Fire;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Charge;

import java.awt.*;

public class Rotom extends Engimon {

    public Rotom(int level, Point position) {
        id = 7;
        species = "Rotom";
        name = "Rotom";
        this.level = level;
        this.position = position;
        elements.add(new Fire());
        elements.add(new Electric());
        skills.add(new Charge(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Rotom~";
    }
}
