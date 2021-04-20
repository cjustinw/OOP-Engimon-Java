package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class Dig extends Skill{
	public Dig(boolean item){
            id = 5;
	    name = "Dig";
	    basePower = 80;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Ground());
	}
}


