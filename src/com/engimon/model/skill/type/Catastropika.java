package com.engimon.model.skill.type;

import com.engimon.model.skill.Skill;
import com.engimon.model.element.*;
import java.util.ArrayList;

public class Catastropika extends Skill{
	public Catastropika(boolean item){
            id = 4;
	    name = "Catastropika";
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
