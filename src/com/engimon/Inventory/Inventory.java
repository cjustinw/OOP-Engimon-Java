import java.util.*;

class Inventory<T> {
    private int numOfElement;
    private List<Myinventory<T>> myinventory;

    public Inventory(){
        myinventory = new List<Myinventory<T>>();
        numOfElement = 0;
    }

    protected void finalize(){
        myinventory.clear()
    }
    
    public void add(T elmt){
        myinventory = new List<Myinventory<T>>();
        myinventory.add(elmt);
        numOfElement = numOfElement + 1;
    }

    public void delAt(int idx){
        if (numOfElement == 0){
            // throw empty
        }
        else{
            myinventory.remove(idx);
        }
    }

    public int getNumOfElement(){
        return numOfElement;
    }
}