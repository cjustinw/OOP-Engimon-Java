package com.engimon.model.map;

import com.engimon.model.engimon.Engimon;

public interface Cellable {
    // objek apapun yang ingin menempati cell harus meng-implement interface ini

    // objek harus memiliki symbol/sprite
    boolean isEngimon();
    
    Engimon getEngimonAtCell();
    
    char getSymbol();
    
    String getImagePath();
}
