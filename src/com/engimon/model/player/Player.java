package com.engimon.model.player;

import com.engimon.model.engimon.Engimon;
import com.engimon.model.map.Cellable;
import com.engimon.model.skill.Skill;
import com.engimon.model.inventory.Inventory;
import java.awt.Point;
import java.util.List;

public class Player implements Cellable{
    private Inventory<Engimon> engimonInventory;
    private Inventory<Skill> skillInventory;
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
        position = new Point(pos);
        engimonInventory = new Inventory<>();
        skillInventory = new Inventory<>();
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
    
    public String[] getAllEngimonName() {
        String[] names = new String[engimonInventory.size()];
        for(int i = 0; i < engimonInventory.size(); i++){
            if(engimonInventory.get(i).getElements().size() == 1){
                names[i] = engimonInventory.get(i).getName() + "/" + engimonInventory.get(i).getElements().get(0).getElmt().toString() + "/Lv." + engimonInventory.get(i).getLevel();
            }
            else{
                names[i] = engimonInventory.get(i).getName() + "/" + engimonInventory.get(i).getElements().get(0).getElmt().toString() + " " + engimonInventory.get(i).getElements().get(1).getElmt().toString() + "/Lv." + engimonInventory.get(i).getLevel();
            }
            
        }
        return names;
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
            engimonInventory.sortEngimon();
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
            if(tmp != E){
                E.setActive(tmp.getPosition());
                activeEngimon = E;
                tmp.setInactive();
            }
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
    
    public boolean isEngimon() {
        return false;
    }
    
    public Engimon getEngimonAtCell() {
        return null;
    }

    public int getActiveEngimonIndex() {
        return engimonInventory.indexOf(activeEngimon);
    }

    public List<Engimon> getEngimonInventory() {
        return engimonInventory.getMyInventory();
    }
}