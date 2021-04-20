package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class SandAttack extends Skill{
	public SandAttack(boolean item){
            id = 22;
	    name = "Sand Attack";
	    basePower = 100;
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
