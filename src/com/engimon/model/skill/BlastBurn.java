package com.engimon.model.skill;

public class BlastBurn extends Skill{
	public BlastBurn(){
		super(1,"Blast Burn",100,1);
		prereqElmt.add(new Fire());
	}
}

