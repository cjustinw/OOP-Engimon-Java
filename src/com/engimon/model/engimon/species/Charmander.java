package com.engimon.model.engimon.species;

import com.engimon.model.element.Fire;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.BlastBurn;

import java.awt.*;
import java.util.ArrayList;

public class Charmander extends Engimon {

    public Charmander(int level, Point position) {
        id = 1;
        species = "Charmander";
        name = "Charmander";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Fire());
        skills = new ArrayList<>();
        skills.add(new BlastBurn(false));
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/charmander.png";
        }
        return "resources/sprites/pokemon/charizard.png";
    }

    public String interact() {
        return "Cha~ Chaa~ Charmander";
    }
}
