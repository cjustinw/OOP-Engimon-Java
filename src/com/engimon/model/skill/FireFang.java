package com.engimon.model.skill;

public class FireFang extends Skill{
	public FireFang(){
		super(16,"Fire Fang",65,1);
		prereqElmt.add(new Fire());
	}
}

