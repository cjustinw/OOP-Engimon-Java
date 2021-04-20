package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class Mist extends Skill{
	public Mist(boolean item){
            id = 12;
	    name = "Mist";
	    basePower = 130;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Water());
	}
}
