package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Dig;

import java.awt.*;
import java.util.ArrayList;

public class Diglet extends Engimon {

    public Diglet(int level, Point position) {
        id = 5;
        species = "Diglet";
        name = "Diglet";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Ground());
        skills = new ArrayList<>();
        skills.add(new Dig(false));
    }
    
    public String getImagePath() {
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Didididi~ Diglet";
    }
}
