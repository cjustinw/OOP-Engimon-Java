package Map;

public class Cell {
    private CellType type;
    private Cellable object;

    public Cell() {

    }

    public Cell(CellType t, Cellable o) {
        type = t;
        object = o;
    }

    //******* Getters & Setters *******//
    // return cell type
    public CellType getType() {
        return type;
    }

    // change cell type
    public void setType(CellType newT) {
        type= newT;
    }

    // return object in the cell
    public Cellable getObject() {
        return object;
    }

    // change object in the cell
    public void setObject(Cellable newO) {
        object = newO;
    }

    //******* Predicate Method *******//
    // check if cell empty
    public boolean isEmpty() {
        return object == null;
    }

    // check if cell contains player
//    public boolean isPlayer() {
//        return (object instanceof Player);
//    }

    // check if cell contains engimon
//    public boolean isEngimon() {
//        return (object instanceof Engimon);
//    }

    //******* Other Behaviour *******//
    // move object from this cell to other cell
    public void moveObjectTo(Cell other) {
        if (!this.isEmpty() && other != null && !other.isEmpty()) {
            other.setObject(object);
            this.setObject(null);
        }
    }
}
