package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class OceanicOperetta extends Skill{
	public OceanicOperetta(boolean item){
            id = 8;
	    name = "Oceanic Operetta";
	    basePower = 195;
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
