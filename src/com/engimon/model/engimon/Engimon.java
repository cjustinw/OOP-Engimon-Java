package com.engimon.model.engimon;

import com.engimon.model.element.Element;
import com.engimon.model.map.Cellable;
import com.engimon.model.skill.CreateSkillItem;
import com.engimon.model.skill.Skill;

import java.awt.*;
import java.util.List;

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
    
    private static int MAX_CUMULATIVE_EXP = 3000;
    

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
    
    public void setExp(int exp) {
        this.exp = exp;
    }
    
    public void setCumulativeExp(int cumExp) {
        cumulativeExp = cumExp;
    }

    public int getExp() {
        return exp;
    }

    public int getCumulativeExp() {
        return cumulativeExp;
    }
    
    public int getMaxCumulativeExp() {
        return MAX_CUMULATIVE_EXP;
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
    
    public boolean isMaxCumulativeExp() {
        return cumulativeExp >= MAX_CUMULATIVE_EXP;
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

    // buat save n load
    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setCumulativeExp(int cExp) {
        cumulativeExp = cExp;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
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
    
    @Override
    public abstract String getImagePath();

    @Override
    public char getSymbol() {
        return 'E';
    }
    
    @Override
    public boolean isEngimon() {
        return true;
    }
    
    @Override
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
    
    public int learnSkill(Skill skill){
        boolean found = false;
        if(skills.size() >= 4){
            return -1;
        }
        for(int i = 0; i < elements.size(); i++) {
            for(int j = 0; j < skill.getPrereqElmt().size(); j++) {
                if(elements.get(i).getElmt().equals(skill.getPrereqElmt().get(j).getElmt())) {
                    found = true;
                    break;
                }
            }
        }
        if(!found) { 
            return 0; 
            
        }
        for(int i = 0; i < skills.size(); i++) {
            if(skills.get(i).getSkillId() == skill.getSkillId()){
                return 1; 
            }
        }
        skill.useItem();
        CreateSkillItem create = new CreateSkillItem();
        skills.add(create.createSkillItem(skill.getSkillId()));
        return 2; 
    }
}
