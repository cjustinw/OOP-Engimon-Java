package com.engimon.model.inventory;

public class Main {
    public static void main(String[] args) {
        Inventory<String> invent = new Inventory<String>();

        assert invent.getNumOfElement() == 0;
        invent.add("test");
        assert invent.getNumOfElement() == 1;
        invent.delAt(0);
        assert invent.getNumOfElement() == 0;
        invent.delAt(0);

    }
}
