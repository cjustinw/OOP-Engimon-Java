package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.ThunderBolt;

import java.awt.*;
import java.util.ArrayList;

public class Pikachu extends Engimon {

    public Pikachu(int level, Point position) {
        id = 3;
        species = "Pikachu";
        name = "Pikachu";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Electric());
        skills = new ArrayList<>();
        skills.add(new ThunderBolt(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Pika~ Pika~";
    }
}
