package com.engimon.model.engimon;

import java.awt.*;
import java.util.List;

import com.engimon.model.element.*;
import com.engimon.model.map.Cellable;
import com.engimon.model.skill.*;

public abstract class Engimon implements Cellable {
    protected int id;
    protected String name;
    protected String species;
    protected int level;
    protected List<Skill> skills;
    protected List<Element> elements;
    protected Point position;
    protected int life;
    private int numOfSkill;
    private int exp;
    private int cumulativeExp;
    private boolean active;
    private String imagePath;
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getCumulativeExp() {
        return cumulativeExp;
    }
    
    public List<Skill> getSkills() {
        return skills;
    }
    
    public List<Element> getElements() {
        return elements;
    }

    public boolean getActive() {
        return active;
    }

    public Point getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPosition(Point P) {
        position = new Point(P);
    }

    public void setActive(Point pos) {
        if(!active) {
            position = new Point(pos);
            active = true;
        }
        else {
            //throw
        }
    }
    
    public void setActive() {
        if(!active) {
            active = true;
        }
        else {
            //throw
        }
    }
    
    public int getLife() {
        return life;
    }
    
    public void setLife() {
        life = 3;
    }
    
    public void reduceLife() {
        life--;
    }
    
    public void setInactive() {
        if(active) {
            position = new Point(-1,-1);
            active = false;
        }
        else{
            // throw
        }
    }

    /* return true jika naik level */
    public boolean addExp(int exp) {
        this.exp += exp;
        cumulativeExp += exp;
        int lvl = (this.exp)/(getLevel()*100);
        if(lvl > 0) {
            level += lvl;
            this.exp = getExp() % (lvl*100);
            return true;
        }
        return false;
    }

    public boolean canBreeding() {
        return level >= 4;
    }

    public void setLevelAfterBreeding() {
        level -= 3;
    }

    public abstract String interact();
    
    public abstract String getImagePath();

    public void learnSkill(Skill skill){
        skills.add(skill);
        numOfSkill++;
    }
    
    public char getSymbol() {
        return 'E';
    }
    
    public boolean isEngimon() {
        return true;
    }
    
    public Engimon getEngimonAtCell() {
        return this;
    }
    
    public double getPower(Engimon other) {
        double maxAdvantage = 0;
        for(int i = 0; i < elements.size(); i++) {
            for(int j = 0; j < other.elements.size(); j++) {
                double advantage = elements.get(i).elementAdvantage(other.elements.get(j).getElmt());
                if(advantage > maxAdvantage) {
                    maxAdvantage = advantage;
                }
            }
        }
        int sumPower = 0;
        for(int i = 0; i < skills.size(); i++) {
            sumPower += skills.get(i).getSkillDamage();
        }
        
        return level * maxAdvantage + (double)sumPower;
    }
}
