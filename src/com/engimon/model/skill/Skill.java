package com.engimon.model.skill;

import java.util.Vector;

import com.engimon.model.element.Element;

public abstract class Skill {
    protected int id;
    protected String name;
    protected int basePower;
    protected int masteryLevel;
    protected Boolean item;
    protected int numOfItem;
    protected Vector<Element> prereqElmt;

    /* Getter */
    public String getSkillName() {
        return this.name;
    }

    public int getSkillId() {
        return this.id;
    }

    public int getSkillDamage() {
        return this.basePower * this.masteryLevel;
    }

    public int getNumOfItem() {
        return this.numOfItem;
    }

    public int getMasteryLevel() {
        return this.masteryLevel;
    }

    public Vector<Element> getPrereqElmt() {
        return this.prereqElmt;
    }

    /* Setter */
    public void setItemStatus(Boolean status) {
        this.item = status;
        this.numOfItem = 1;
    }

    public void addSkill() {
        if (!item) {
            // throw
        }
        numOfItem++;
    }

    public void useSkill() {
        if (!item) {
            // throw
        }
        numOfItem--;
    }

    public void setMasteryLevel(int lvl) {
        this.masteryLevel = lvl;
    }

    /* Other method */

    public void addItem() {
        if(item){
            numOfItem++;
        }
        else{
            // throw
        }
    }
    
    public void useItem() {
        if(numOfItem > 0) {
            numOfItem--;
        }
        else {
            // destroy
        }
    }
}
