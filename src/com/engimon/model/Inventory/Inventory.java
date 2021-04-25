package com.engimon.model.inventory;

import com.engimon.model.engimon.Engimon;
import java.util.*;

public class Inventory<T> {
    private List<T> myinventory;
    private int numOfElement;

    public Inventory() {
        this.myinventory = new ArrayList<>();
        numOfElement = 0;
    }

    public void add(T elmt) {
        this.myinventory.add(elmt);
        numOfElement += 1;
    }

    public void remove(int idx) {
        if (numOfElement == 0) {
            System.out.println("cannot delete, empty inventory");
        } else {
            System.out.println("deleted 1 item");
            this.myinventory.remove(idx);
            this.numOfElement -= 1;
        }
    }
    
    public T get(int idx) {
        return myinventory.get(idx);
    }
    
    public void sortEngimon() {
        Collections.sort(myinventory, new CompareEngimonByElement().thenComparing(new CompareEngimonByLevel()));
    }

    public int size() {
        return this.numOfElement;
    }
    
    class CompareEngimonByElement implements Comparator<T> {
        @Override
        public int compare(T a, T b) {
            Engimon a1 = (Engimon)a;
            Engimon b1 = (Engimon)b;
            String element1, element2;
            if(a1.getElements().size() == 1){
                element1 = a1.getElements().get(0).getElmt().toString();
            }
            else{
                element1 = a1.getElements().get(0).getElmt().toString() + "" + a1.getElements().get(1).getElmt().toString();
            }
            if(b1.getElements().size() == 1){
                element2 = b1.getElements().get(0).getElmt().toString();
            }
            else{
                element2 = b1.getElements().get(0).getElmt().toString() + "" + b1.getElements().get(1).getElmt().toString();
            }
            return element1.compareTo(element2);
        }
    }
   
    class CompareEngimonByLevel implements Comparator<T> {
        @Override
        public int compare(T a, T b) {
            Engimon a1 = (Engimon)a;
            Engimon b1 = (Engimon)b;
            return b1.getLevel() - a1.getLevel();
        }
    }
    
}
