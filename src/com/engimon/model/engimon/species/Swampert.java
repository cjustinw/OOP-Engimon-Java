package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.MudShot;

import java.awt.*;

public class Swampert extends Engimon {

    public Swampert(int level, Point position) {
        id = 13;
        species = "Swampert";
        name = "Swampert";
        this.level = level;
        this.position = position;
        elements.add(new Water());
        elements.add(new Ground());
        skills.add(new MudShot(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Swampert~";
    }
}
