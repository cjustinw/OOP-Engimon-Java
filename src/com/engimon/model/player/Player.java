package com.engimon.model.player;

import com.engimon.model.engimon.Engimon;
import com.engimon.model.map.Cellable;
import com.engimon.model.skill.Skill;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Player implements Cellable{
    private List<Engimon> engimonInventory;
    private List<Skill> skillInventory;
    private int maxSkillItem;
    private int maxInventory;
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
        position = new Point(pos.x, pos.y);
        engimonInventory = new ArrayList<>();
        skillInventory = new ArrayList<>();
        maxSkillItem = 4;
        maxInventory = 30;
        numOfItem = 0;
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
    
    public Engimon getEngimonAtIndex(int n) {
        return engimonInventory.get(n);
    }
    
    public void setImagePath(String S, int n) {
        if(S.equals("U")){
            if(n == 1){
                imagePath = "resources/sprites/player/up2.png";
            }
            else {
                imagePath = "resources/sprites/player/up3.png";
            }
        }
        else if(S.equals("D")) {
            if(n == 1){
                imagePath = "resources/sprites/player/down2.png";
            }
            else {
                imagePath = "resources/sprites/player/down3.png";
            }
        }
        else if(S.equals("L")){
            if(n == 1){
                imagePath = "resources/sprites/player/left2.png";
            }
            else {
                imagePath = "resources/sprites/player/left3.png";
            }
        }
        else if(S.equals("R")){
            if(n == 1){
                imagePath = "resources/sprites/player/right2.png";
            }
            else {
                imagePath = "resources/sprites/player/right3.png";
            }
        }
    }
    
    public boolean isInventoryFull() {
        return numOfItem >= maxInventory;
    }
    
    public void addEngimon(Engimon E) {
        if(!isInventoryFull()) {
            engimonInventory.add(E);
            numOfItem++;
        }
        else {
            // throw
        }
    }
    
    public void addSkillItem(Skill S) {
        if(!isInventoryFull()) {
            skillInventory.add(S);
            numOfItem++;
        }
        else {
            // throw
        }
    }
    
    public void setActiveEngimon(Engimon E) {
        if(activeEngimon != null){
            Engimon tmp = activeEngimon;
            E.setActive(tmp.getPosition());
            activeEngimon = E;
            tmp.setInactive();
        }
        else {
            E.setActive();
            activeEngimon = E;
        }
    }
    
    public Engimon getActiveEngimon() {
        return activeEngimon;
    }
    
    public char getSymbol() {
        return 'P';
    }
    
//    /* Getter */
//    public int getNumOfAllItem() {
//        int skillCount = 0;
//        for (int i = 0; i < getNumOfSkillItem(); i++) {
//            skillCount += skillInventory[i].getNumOfItem();
//        }
//        return engimonInventory.getNumOfElement() + skillCount;
//    }
//
//    public int getNumOfSkillItem() {
//        return skillInventory.getNumOfElement();
//    }
//
//    public int getNumOfEngimon() {
//        return activeEngimon.getNumOfElement();
//    }
//
//    public Engimon getActiveEngimon() {
//        return activeEngimon;
//    }
//
//    public Engimon getEngimonByIndex(int idx) {
//        if (idx >= engimonInventory.getNumOfElement()) {
//            // throw ItemNotFoundException();
//        }
//        return skillInventory[idx];
//    }
//
//    public Skill getSkillByIndex(int idx) {
//        if (idx >= skillInventory.getNumOfElement()) {
//            throw ItemNotFoundException();
//        }
//        return skillInventory[idx];
//    }
//
//    public Point getPlayerPosition() {
//        return position;
//    }
//
//    /* Setter */
//    public void setActiveEngimon(int idx) {
//
//        Point P = new Point(2, 1);
//        if (activeEngimon != NULL) {
//            activeEngimon.setActive(true);
//            P.setX(activeEngimon.getPosition().getX());
//            P.setY(activeEngimon.getPosition().getY());
//            activeEngimon.setPosition(0, 0);
//        }
//        activeEngimon = getEngimonByIndex(idx);
//        activeEngimon.setActive(true);
//        activeEngimon.setPosition(P);
//    }
//
//    public void setEngimonName(int idx, string name) {
//        getEngimonByIndex(idx).setName(name);
//    }
//
//    /* Conditional Checking */
//    public bool isInventoryFull() {
//        return (getNumOfAllItem() >= maxInventory);
//    }
//
//    public Skill isSkillItemExist(Skill skill) {
//        for (int i = 0; i < skillInventory.getNumOfElement(); i++) {
//            if (skillInventory[i].getSkiilName() == skill.getSkillName()) {
//                return skillInventory[i];
//            }
//        }
//    }
//
//    /* Other Methods */
//    public void addEngimon(Engimon engimon) {
//        engimon.setPosition(0, 0);
//    }
//
//    public void removeEngimon(Engimon engimon) {
//        if (getActiveEngimon() == engimon) {
//            activeEngimon = NULL;
//        }
//        for (int i = 0; i < engimonInventory.getNumOfElement(); i++) {
//            if (engimonInventory[i] == engimon) {
//                engimonInventory.delAt(i);
//                break;
//            }
//        }
//    }
//
//    public void addSkillItem(Skill skill) {
//        skillInventory.add(skill);
//    }
//
//    public void move(string command) {
//        activeEngimon.setPosition(getPlayerPosition());
//        if (command == "w") {
//            position.addY();
//        } else if (command == "a") {
//            position.subX();
//        } else if (command == "s") {
//            position.subY();
//        } else if (command == "d") {
//            position.addX();
//        }
//    }
//
//    void showEngimonDescription(int idx) {
//        getEngimonByIndex(idx).showDescription();
//    }
//
//    void showAllEngimon() {
//        System.out.println("Engimon list: ");
//        for (int i = 0; i < engimonInventory.getNumOfElement(); i++) {
//            System.out.println("   " + i + 1 + ". " + engimonInventory[i].getName() + " ("
//                    + engimonInventory[i].getSpecies() + ") Lvl." + engimonInventory[i].getCurrentLevel());
//        }
//    }
//
//    void showAllSkillItem() {
//        System.out.println("Skill Item list: ");
//        for (int i = 0; i < skillInventory.getNumOfElement(); i++) {
//            System.out.println("   " + i + 1 + ". " + skillInventory[i].getSkillName() + " (x"
//                    + skillInventory[i].getNumOfItem() + ")");
//        }
//    }
//
//    void engimonBreed(int idx1, int idx2, string name) {
//        addEngimon(getEngimonByIndex(idx1).breed(getEngimonByIndex(idx2), name));
//    }
//
//    void showEngimonBySkillItem(Skill skill) {
//        System.out.println("Available engimon that can learn " + skill.getSkillName() + ": ");
//        for (int i = 0; i < engimonInventory.getNumOfElement(); i++) {
//            for (int j = 0; j < engimonInventory[i].getElement().size(); j++) {
//                for (int k = 0; k < skill.getPrereqElmt().size(); k++) {
//                    if (engimonInventory[i].getElement()[j].getElmt() == skill.getPrereqElmt()[k].getElmt()) {
//                        bool exist = false;
//                        for (int l = 0; l < engimonInventory[i].getSkill().size(); l++) {
//                            if (engimonInventory[i].getSkill()[l].getSkillId() == skill.getSkillId()) {
//                                exist = true;
//                                break;
//                            }
//                        }
//                        if (!exist) {
//                            System.out.println("   " + i + 1 + ". " + engimonInventory[i].getName() + " ("
//                                    + engimonInventory[i].getSpecies() + ")" + " Lvl."
//                                    + engimonInventory[i].getCurrentLevel());
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    void useSkillItem(Skill skill, Engimon engimon) {
//        engimon.learnSkill(CreateSkill(skill.getSkillId()));
//        skill.useSkill();
//        if (skill.getNumOfItem() == 0) {
//            for (int i = 0; i < skillInventory.getNumOfElement(); i++) {
//                if (skillInventory[i].getSkillId() == skill.getSkillId()) {
//                    skillInventory.delAt(i);
//                    break;
//                }
//            }
//        }
//    }
}