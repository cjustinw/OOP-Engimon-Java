package com.engimon.model.skill;

public class ElectroBall extends Skill{
	public ElectroBall(){
		super(17,"Electro Ball",100,1);
		prereqElmt.add(new Electric());
		prereqElmt.add(new Fire());
	}
}

