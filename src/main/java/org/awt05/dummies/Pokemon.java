package org.awt05.dummies;

import java.util.List;

public class Pokemon {
    private String nickname;
    private boolean isDamage;
    private int id;
    private List <String> listTypes;
    private List <Species> listSpecies;

    public Pokemon(boolean isDamage){
        this.isDamage = isDamage;
    }

    public boolean isDamage() {
        return isDamage;
    }

    public void heal() {
        isDamage = false;
    }

    @Override
    public String toString()
    {
        return this.getClass().toString();
    }
}