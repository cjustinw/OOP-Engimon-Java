package com.engimon.model.skill;

import com.engimon.model.skill.type.BlastBurn;

public class Main {
    public static void main(String[] args) {
        BlastBurn blast = new BlastBurn(true);
        System.out.println(blast.getSkillName());
        if (blast.getSkillName() == "Blast Burn") {
            System.out.println("true 1");
        }
        if (blast.getSkillId() == 1) {
            System.out.println("true 2");
        }
        if (blast.getSkillDamage() == 100) {
            System.out.println("true 3");
        }
        if (blast.getNumOfItem() == 1) {
            System.out.println("true 4");
        }
        if (blast.getMasteryLevel() == 1) {
            System.out.println("true 5");
        }
        blast.setMasteryLevel(2);
        if (blast.getMasteryLevel() == 2) {
            System.out.println("true 6");
        }

    }
}
