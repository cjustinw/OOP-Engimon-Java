package com.engimon.model.map;

public interface Cellable {
    // objek apapun yang ingin menempati cell harus meng-implement interface ini

    // objek harus memiliki symbol/sprite
    char getSymbol();

    String getSprite();
}
