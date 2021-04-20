package com.engimon.model.engimon.species;

import com.engimon.model.element.Electric;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.ThunderBolt;

import java.awt.*;

public class Pikachu extends Engimon {

    public Pikachu(int level, Point position) {
        id = 3;
        species = "Pikachu";
        name = "Pikachu";
        this.level = level;
        this.position = position;
        elements.add(new Electric());
        skills.add(new ThunderBolt(false));
    }

    public String interact() {
        return "Pika~ Pika~";
    }
}
