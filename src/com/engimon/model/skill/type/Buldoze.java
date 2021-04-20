package com.engimon.model.skill.type;

import com.engimon.model.skill.Skill;
import com.engimon.model.element.*;

public class Buldoze extends Skill{
	public Buldoze(boolean item){
            id = 21;
	    name = "Buldoze";
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
