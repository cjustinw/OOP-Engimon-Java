package com.engimon.model.inventory;

public class Main {
    public static void main(String[] args) {
        Inventory<String> invent = new Inventory<String>();

        assert invent.size() == 0;
        invent.add("test");
        assert invent.size() == 1;
        invent.remove(0);
        assert invent.size() == 0;
        invent.remove(0);

    }
}
