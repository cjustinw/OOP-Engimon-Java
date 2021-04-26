package com.engimon.model.player;

import com.engimon.model.element.Element.ElmtType;
import com.engimon.model.engimon.CreateEngimon;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.map.Cellable;
import com.engimon.model.skill.Skill;
import com.engimon.model.inventory.Inventory;
import com.engimon.model.skill.CreateSkill;
import com.engimon.model.skill.CreateSkillItem;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player implements Cellable {
    private Inventory<Engimon> engimonInventory;
    private Inventory<Skill> skillInventory;
    private int maxSkillItem;
    private int maxInventory = 20;
    private int numOfItem;
    private Point position;
    private Engimon activeEngimon;
    private String imagePath;
    private String imageDownPath;
    private String imageDown1Path;
    private String imageDown2Path;
    private String imageUp1Path;
    private String imageUp2Path;
    private String imageLeft1Path;
    private String imageLeft2Path;
    private String imageRight1Path;
    private String imageRight2Path;

    public Player(Point pos) {
        position = new Point(pos);
        engimonInventory = new Inventory<>();
        skillInventory = new Inventory<>();
        maxSkillItem = 4;
        activeEngimon = null;
        imageDownPath = "resources/sprites/player/down1.png";
        imageDown1Path = "resources/sprites/player/down2.png";
        imageDown2Path = "resources/sprites/player/down3.png";
        imageUp1Path = "resources/sprites/player/up2.png";
        imageUp2Path = "resources/sprites/player/up2.png";
        imageLeft1Path = "resources/sprites/player/left2.png";
        imageLeft2Path = "resources/sprites/player/left3.png";
        imageRight1Path = "resources/sprites/player/right2.png";
        imageRight2Path = "resources/sprites/player/right3.png";
        imagePath = imageDownPath;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point P) {
        position = new Point(P);
    }

    public String getImagePath() {
        return imagePath;
    }
    
    public int getNumOfEngimon() {
        return engimonInventory.size();
    }

    public String[] getAllEngimonName() {
        String[] names = new String[engimonInventory.size()];
        for (int i = 0; i < engimonInventory.size(); i++) {
            if (engimonInventory.get(i).getElements().size() == 1) {
                names[i] = engimonInventory.get(i).getName() + " / "
                        + engimonInventory.get(i).getElements().get(0).getElmt().toString() + " / Lv."
                        + engimonInventory.get(i).getLevel();
            } else {
                names[i] = engimonInventory.get(i).getName() + " / "
                        + engimonInventory.get(i).getElements().get(0).getElmt().toString() + " "
                        + engimonInventory.get(i).getElements().get(1).getElmt().toString() + " / Lv."
                        + engimonInventory.get(i).getLevel();
            }
        }
        return names;
    }
    
    public String[] getAllSkillItemName() {
        String[] names = new String[skillInventory.size()];
        for (int i = 0; i < skillInventory.size(); i++) {
            names[i] = skillInventory.get(i).getSkillName() + " / "
                    + skillInventory.get(i).getSkillDamage() + " / x"
                    + skillInventory.get(i).getNumOfItem();
        }
        return names;
    }

    public Engimon getEngimonAtIndex(int n) {
        return engimonInventory.get(n);
    }
    
    public Skill getSkillItemAtIndex(int n) {
        return skillInventory.get(n);
    }
     
    public void setImagePath(String S, int n) {
        if (S.equals("U")) {
            if (n == 1) {
                imagePath = "resources/sprites/player/up2.png";
            } else {
                imagePath = "resources/sprites/player/up3.png";
            }
        } else if (S.equals("D")) {
            if (n == 1) {
                imagePath = "resources/sprites/player/down2.png";
            } else {
                imagePath = "resources/sprites/player/down3.png";
            }
        } else if (S.equals("L")) {
            if (n == 1) {
                imagePath = "resources/sprites/player/left2.png";
            } else {
                imagePath = "resources/sprites/player/left3.png";
            }
        } else if (S.equals("R")) {
            if (n == 1) {
                imagePath = "resources/sprites/player/right2.png";
            } else {
                imagePath = "resources/sprites/player/right3.png";
            }
        }
    }

    public boolean isInventoryFull() {
        return getNumOfEngimon() + getNumOfSkillItem()>= maxInventory;
    }

    public void addEngimon(Engimon E) {
        if(!isInventoryFull()) {
            E.setLife();
            E.setPosition(new Point(-1,-1));
            engimonInventory.add(E);
            engimonInventory.sortEngimon();
        } else {
            // throw
        }
    }
    
    public int getNumOfSkillItem() {
        int count = 0;
        for(int i = 0; i < skillInventory.size(); i++) {
            count += skillInventory.get(i).getNumOfItem();
        }
        return count;
    }

    public void addSkillItem(Skill S) {
        if (!isInventoryFull()) {
            boolean found = false;
            for(int i = 0; i < skillInventory.size(); i++){
                if(skillInventory.get(i).getSkillName().equals(S.getSkillName())){
                    found = true;
                    skillInventory.get(i).addItem();
                    break;
                }
            }
            if(!found){
                CreateSkillItem create = new CreateSkillItem();
                skillInventory.add(create.createSkillItem(S.getSkillId()));
                skillInventory.sortSkillItem();
            }
            
        } else {
            // throw
        }
    }

    public void setActiveEngimon(Engimon E) {
        if(E != null){
            if(activeEngimon != null){
                Engimon tmp = activeEngimon;
                if(tmp != E){
                    E.setActive(tmp.getPosition());
                    activeEngimon = E;
                    tmp.setInactive();
                }
            }
            else {
                if(position.y != 0){
                    E.setActive(new Point(position.x, position.y - 1));
                }
                else{
                    E.setActive(new Point(position.x + 1, position.y));
                }
                activeEngimon = E;
            }
        }
        else{
            activeEngimon = null;
        }
    }
    
    public void removeEngimon(Engimon E) {
        for(int i = 0; i < engimonInventory.size(); i++) {
            if(engimonInventory.get(i) == E) {
                engimonInventory.remove(i);
                break;
            }
        }
    }

    public Engimon getActiveEngimon() {
        return activeEngimon;
    }

    @Override
    public char getSymbol() {
        return 'P';
    }

    @Override
    public boolean isEngimon() {
        return false;
    }

    @Override
    public Engimon getEngimonAtCell() {
        return null;
    }

    public int getActiveEngimonIndex() {
        return engimonInventory.indexOf(activeEngimon);
    }

    public List<Engimon> getEngimonInventory() {
        return engimonInventory.getMyInventory();
    }
    
    public void removeEngimonAtIndex(int idx){
        engimonInventory.remove(idx);
    }
    
    public void removeSkillItemAtIndex(int idx){
        if(skillInventory.get(idx).getNumOfItem() > 1){
            skillInventory.get(idx).useItem();
        }
        else{
            skillInventory.remove(idx);
        }
    }
    
    public int getHighestLevelEngimon() {
        int max = 0;
        for(int i = 0; i < engimonInventory.size(); i++){
            if(engimonInventory.get(i).getLevel() > max) {
                max = engimonInventory.get(i).getLevel();
            }
        }
        return max;
    }
    
    public String learnSkillItem(int idxE, int idxS ) {
        Engimon E = getEngimonAtIndex(idxE);
        Skill S = getSkillItemAtIndex(idxS);
        int result = E.learnSkill(S);
        switch (result) {
            case -1 -> {
                return "Cannot learn any new skills anymore";
            }
            case 0 -> {
                return "Incompatible Skill Item";
            }
            case 1 -> {
                return E.getName() + " has already learned the skill";
            }
            default -> {
                removeSkillItemAtIndex(idxS);
                return E.getName() + " has learned " + S.getSkillName();
            }
        }
    }
    

    public List<Skill> getSkillInventory() {
        return skillInventory.getMyInventory();
    }

    public Engimon breedEngimon(Engimon E1, Engimon E2) {
        Engimon E;
        Skill S;
        CreateEngimon create = new CreateEngimon();
        CreateSkill screate = new CreateSkill();
        double E1advantage = E1.getElements().get(0).elementAdvantage(E2.getElements().get(0).getElmt());
        double E2advantage = E2.getElements().get(0).elementAdvantage(E1.getElements().get(0).getElmt());
        List<Skill> inheritSkill = new ArrayList<>();

        for(int i = 0 ; i< E1.getSkills().size(); i++){
            S = screate.createSkillItem(E1.getSkills().get(i).getSkillId());
            S.setMasteryLevel(E1.getSkills().get(i).getMasteryLevel());
            inheritSkill.add(S);
        }
        
        for(int i = 0; i < E2.getSkills().size(); i++) {
            boolean isSame = false;
            for(int j = 0; j < inheritSkill.size(); j++) {
                if(E2.getSkills().get(i).getSkillName().equals(inheritSkill.get(j).getSkillName())){
                    if(inheritSkill.get(j).getMasteryLevel() < 3){
                        inheritSkill.get(j).setMasteryLevel(inheritSkill.get(j).getMasteryLevel()+1);
                    }
                    isSame = true;
                }
            }
            if(!isSame){
                S = screate.createSkillItem(E2.getSkills().get(i).getSkillId());
                S.setMasteryLevel(E2.getSkills().get(i).getMasteryLevel());
                inheritSkill.add(S);
            }
        }
        
        Collections.sort(inheritSkill, new CompareSkillByMasteryLevel());
            
        if(E1advantage > E2advantage) {
            E = create.createEngimon(E1.getId(), E1.getLevel(), new Point(-1,-1));
        }
        else if(E1advantage < E2advantage) {
            E = create.createEngimon(E2.getId(), E2.getLevel(), new Point(-1,-1));
        }
        else{
            if(E1.getElements().get(0).getElmt().equals(E2.getElements().get(0).getElmt())){
                E = create.createEngimon(E1.getId(), E1.getLevel(), new Point(-1,-1));
            }
            else{
                if(E1.getElements().get(0).getElmt().equals(ElmtType.FIRE) && E2.getElements().get(0).getElmt().equals(ElmtType.ELECTRIC) || E2.getElements().get(0).getElmt().equals(ElmtType.FIRE) && E1.getElements().get(0).getElmt().equals(ElmtType.ELECTRIC)) {
                    E = create.createEngimon(7, E1.getLevel(), new Point(-1,-1));
                }
                else if (E1.getElements().get(0).getElmt().equals(ElmtType.WATER) && E2.getElements().get(0).getElmt().equals(ElmtType.ICE) || E2.getElements().get(0).getElmt().equals(ElmtType.WATER) && E1.getElements().get(0).getElmt().equals(ElmtType.ICE)){
                    E = create.createEngimon(12, E1.getLevel(), new Point(-1,-1));
                }
                else{
                    E = create.createEngimon(13, E1.getLevel(), new Point(-1,-1));
                }
            }
        }
        
        int i = 0;
        while(E.getSkills().size() < 4 && i < inheritSkill.size()){
            if(E.getSkills().get(0).getSkillId() == inheritSkill.get(i).getSkillId()){
                E.getSkills().add(1, inheritSkill.get(i));
                E.getSkills().remove(0);
            }
            else{
                E.getSkills().add(inheritSkill.get(i));
            }
            i++;
        }
        
        engimonInventory.add(E);
        return E;
    }
    
    class CompareSkillByMasteryLevel implements Comparator<Skill> {
        @Override
        public int compare(Skill a, Skill b) {
            return b.getMasteryLevel() - a.getMasteryLevel();
        }

    }
}