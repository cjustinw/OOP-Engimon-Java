package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class FreezeShock extends Skill{
	public FreezeShock(boolean item){
            id = 9;
	    name = "Freeze Shock";
	    basePower = 110;
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
