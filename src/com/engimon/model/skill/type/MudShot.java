package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class MudShot extends Skill{
	public MudShot(boolean item){
            id = 13;
	    name = "Mud Shot";
	    basePower = 90;
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
