package com.engimon.model.skill.type;

import com.engimon.model.skill.Skill;
import com.engimon.model.element.*;

public class BoneRush extends Skill{
	public BoneRush(boolean item){
            id = 20;
	    name = "Bone Rush";
	    basePower = 50;
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
