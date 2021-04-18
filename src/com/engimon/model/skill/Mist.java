package com.engimon.model.skill;

public class Mist extends Skill{
	public Mist(){
		super(12,"Mist",130,1);
		prereqElmt.add(new Water());
	}
}
