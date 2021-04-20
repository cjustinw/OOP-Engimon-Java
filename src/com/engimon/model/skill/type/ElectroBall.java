package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class ElectroBall extends Skill{
	public ElectroBall(boolean item){
            id = 17;
	    name = "Electro Ball";
	    basePower = 100;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Electric());
            prereqElmt.add(new Fire());
	}
}

