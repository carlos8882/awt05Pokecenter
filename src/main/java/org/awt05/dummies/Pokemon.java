package org.awt05.dummies;

import java.util.List;

public class Pokemon {
    private String nickname;
    private boolean isDamage;

    public Pokemon(boolean isDamage){ this.isDamage = isDamage; }

    public boolean isDamage() {
        return isDamage;
    }

    public void setIsDamage(boolean value) {
        isDamage = value;
    }

    @Override
    public String toString()
    {
        return this.getClass().toString();
    }

    public String getNickname() {
        return nickname;
    }
}