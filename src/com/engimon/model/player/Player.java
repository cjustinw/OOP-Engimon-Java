//package Player;
//
//import com.engimon.model.inventory.*;
//
//public class Player {
//    private Inventory engimonInventory;
//    private Inventory skillInventory;
//    private int maxSkillItem;
//    private int maxInventory;
//    private Point position;
//    private Engimon activeEngimon;
//
//    public Player() {
//
//    }
//
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
//}