package com.engimon.model.skill;

public class HydroCanon extends Skill{
	public HydroCanon(){
		super(23,"Hydro Canon",150,1);
		prereqElmt.add(new Water());
		prereqElmt.add(new Ice());
	}
}
