package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class ThunderBolt extends Skill{
	public ThunderBolt(boolean item){
            id = 3;
	    name = "Thunder Bolt";
	    basePower = 110;
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
