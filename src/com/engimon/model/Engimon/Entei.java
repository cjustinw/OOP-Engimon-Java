package com.engimon.model.Engimon;

import com.engimon.model.element.Element;
import com.engimon.model.element.Fire;

public class Entei extends Engimon {
    private char symbol = 'f';
    private String sprite = "resource/sprites/pokemon/entei.png";

    public Entei(){
        super();
        elements.add(new Fire());
    }

    @Override
    public void interact() {

    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char s){
        // symbol bisa berubah kalo level lebih besar
        symbol = s;
    }

    @Override
    public String getSprite() {
        return sprite;
    }

    public void setSprite(String newS) {
        // sprite jg bisa berubah
        sprite = newS;
    }
}
