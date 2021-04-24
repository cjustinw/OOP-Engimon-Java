package com.engimon.model.engimon.species;

import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.WaterGun;

import java.awt.*;
import java.util.ArrayList;

public class Squirtle extends Engimon {

    public Squirtle(int level, Point position) {
        id = 8;
        species = "Squirtle";
        name = "Squirtle";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Water());
        skills = new ArrayList<>();
        skills.add(new WaterGun(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Squirtle~";
    }
}
