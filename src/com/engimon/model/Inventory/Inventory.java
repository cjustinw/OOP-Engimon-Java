//package com.engimon.model.inventory;
//
//import java.util.*;
//
//class Inventory<T> {
//    private int numOfElement;
//    private List<T> myinventory;
//
//    public Inventory(){
//        myinventory = new ArrayList<T>();
//        numOfElement = 0;
//    }
//
//    protected void finalize(){
//        myinventory.clear()
//    }
//    
//    public void add(T elmt){
//        myinventory.add(elmt);
//        numOfElement += 1;
//    }
//
//    public void delAt(int idx){
//        if (numOfElement == 0){
//            // throw empty
//        }
//        else{
//            myinventory.remove(idx);
//            numOfElement -= 1;
//        }
//    }
//
//    public int getNumOfElement(){
//        return numOfElement;
//    }
//}
