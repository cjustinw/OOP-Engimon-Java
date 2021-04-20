package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class Eruption extends Skill{
	public Eruption(boolean item){
            id = 2;
	    name = "Eruption";
	    basePower = 200;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Fire());
	}
}
