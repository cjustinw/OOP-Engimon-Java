package com.engimon.model.skill.type;

import com.engimon.model.skill.Skill;
import com.engimon.model.element.*;
import java.util.ArrayList;

public class BlastBurn extends Skill{
	public BlastBurn(boolean item){
            id = 1;
	    name = "Blast Burn";
	    basePower = 100;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt = new ArrayList<>();
            prereqElmt.add(new Fire());
	}
}

