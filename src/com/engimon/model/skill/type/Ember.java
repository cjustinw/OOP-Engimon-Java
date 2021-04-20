package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class Ember extends Skill{
	public Ember(boolean item){
            id = 14;
	    name = "Ember";
	    basePower = 40;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Fire());
            prereqElmt.add(new Electric());
	}
}
