package com.engimon.model.engimon.species;

import com.engimon.model.element.Fire;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Eruption;

import java.awt.*;
import java.util.ArrayList;

public class Entei extends Engimon {

    public Entei(int level, Point position) {
        id = 2;
        species = "Entei";
        name = "Entei";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Fire());
        skills = new ArrayList<>();
        skills.add(new Eruption(false));
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/entei.png";
        }
        return "resources/sprites/pokemon/entei 2.png";
    }

    public String interact() {
        return "Rrrrraaawrrrr~";
    }
}
