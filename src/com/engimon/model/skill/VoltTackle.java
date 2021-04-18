package com.engimon.model.skill;

public class VoltTackle extends Skill{
	public VoltTackle(){
		super(19,"Volt Tackle",120,1);
		prereqElmt.add(new Electric());
	}
}
