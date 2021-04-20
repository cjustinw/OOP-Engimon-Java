package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class IceHammer extends Skill{
	public IceHammer(boolean item){
            id = 26;
	    name = "Ice Hammer";
	    basePower = 100;
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
