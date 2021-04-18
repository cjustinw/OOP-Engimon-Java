package com.engimon.model.skill;

public class OceanicOperetta extends Skill{
	public OceanicOperetta(){
		super(8,"Oceanic Operetta",195,1);
		prereqElmt.add(new Water());
	}
}
