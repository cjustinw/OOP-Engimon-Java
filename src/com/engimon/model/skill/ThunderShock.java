package com.engimon.model.skill;

public class ThunderShock extends Skill{
	public ThunderShock(){
		super(18,"Thunder Shock",40,1);
		prereqElmt.add(new Electric());
	}
}

