package com.engimon.model.engimon.species;

import com.engimon.model.element.Fire;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.Eruption;

import java.awt.*;

public class Entei extends Engimon {

    public Entei(String name, int level, Point position) {
        id = 2;
        species = "Entei";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Fire());
        skills.add(new Eruption());
    }

    public String interact() {
        return "Rrrrraaawrrrr~";
    }
}
