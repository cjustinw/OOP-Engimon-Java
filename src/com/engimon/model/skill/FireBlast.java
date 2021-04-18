package com.engimon.model.skill;

public class FireBlast extends Skill{
	public FireBlast(){
		super(15,"Fire Blast",110,1);
		prereqElmt.add(new Fire());
	}
}

