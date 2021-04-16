package com.engimon.model.Engimon;

public class Entei extends Engimon {
    private char symbol = 'f';
    private String sprite = "resource/sprites/pokemon/entei.png";

    public Entei(){

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
