package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;
import java.util.ArrayList;

public class VoltTackle extends Skill{
	public VoltTackle(boolean item){
            id = 19;
	    name = "Volt Tackle";
	    basePower = 210;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt = new ArrayList<>();
            prereqElmt.add(new Electric());
	}
}
