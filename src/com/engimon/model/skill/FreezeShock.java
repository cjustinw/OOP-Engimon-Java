package com.engimon.model.skill;

public class FreezeShock extends Skill{
	public FreezeShock(){
		super(9,"Freeze Shock",110,1);
		prereqElmt.add(new Ice());
	}
}
