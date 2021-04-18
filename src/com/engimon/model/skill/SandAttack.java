package com.engimon.model.skill;

public class SandAttack extends Skill{
	public SandAttack(){
		super(22,"Sand Attack",100,1);
		prereqElmt.add(new Ground());
	}
}
