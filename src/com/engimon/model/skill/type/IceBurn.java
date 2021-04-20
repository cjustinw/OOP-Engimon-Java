package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class IceBurn extends Skill{
	public IceBurn(boolean item){
            id = 10;
	    name = "Ice Burn";
	    basePower = 210;
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
