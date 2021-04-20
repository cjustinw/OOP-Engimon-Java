package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class Charge extends Skill{
	public Charge(boolean item){
            id = 11;
	    name = "Charge";
	    basePower = 100;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Electric());
	}
}
