package com.engimon.model.inventory;

import java.util.*;

class Inventory<T> {
    private ArrayList<T> myinventory;
    private int numOfElement;

    public Inventory() {
        this.myinventory = new ArrayList<>();
        numOfElement = 0;
    }

    public void add(T elmt) {
        this.myinventory.add(elmt);
        numOfElement += 1;
    }

    public void delAt(int idx) {
        if (numOfElement == 0) {
            System.out.println("cannot delete, empty inventory");
        } else {
            System.out.println("deleted 1 item");
            this.myinventory.remove(idx);
            this.numOfElement -= 1;
        }
    }

    public int getNumOfElement() {
        return this.numOfElement;
    }
}
