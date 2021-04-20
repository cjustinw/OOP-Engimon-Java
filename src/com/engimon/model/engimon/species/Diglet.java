package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Dig;

import java.awt.*;

public class Diglet extends Engimon {

    public Diglet(int level, Point position) {
        id = 5;
        species = "Diglet";
        name = "Diglet";
        this.level = level;
        this.position = position;
        elements.add(new Ground());
        skills.add(new Dig(false));
    }

    public String interact() {
        return "Didididi~ Diglet";
    }
}
