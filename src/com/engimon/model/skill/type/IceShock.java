package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class IceShock extends Skill{
	public IceShock(boolean item){
            id = 27;
	    name = "Ice Shock";
	    basePower = 50;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Ice());
	}
}
