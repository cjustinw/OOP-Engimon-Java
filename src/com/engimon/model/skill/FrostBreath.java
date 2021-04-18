package com.engimon.model.skill;

public class FrostBreath extends Skill{
	public FrostBreath(){
		super(28,"Frost Breath",80,1);
		prereqElmt.add(new Ice());
		prereqElmt.add(new Water());
	}
}
