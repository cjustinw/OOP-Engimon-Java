package com.engimon.model.engimon.species;

import com.engimon.model.element.Fire;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.BlastBurn;

import java.awt.*;

public class Charmander extends Engimon {

    public Charmander(int level, Point position) {
        id = 1;
        species = "Charmander";
        name = "Charmander";
        this.level = level;
        this.position = position;
        elements.add(new Fire());
        skills.add(new BlastBurn(false));
    }

    public String interact() {
        return "Cha~ Chaa~ Charmander";
    }
}
