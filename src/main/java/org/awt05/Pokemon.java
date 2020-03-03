package org.awt05;

import java.util.UUID;

public abstract class Pokemon {

    private String pokeId;
    private String nickname;
    private boolean isDamaged;

    public Pokemon(){
        this.getClass().getSimpleName();
        this.pokeId= UUID.randomUUID().toString();
        this.nickname="None";
        this.isDamaged=false;
    }
    public String getPokeId(){
        return pokeId;
    }
    public String getNickname(){
        return nickname;
    }
    public boolean getIsDamaged(){
        return isDamaged;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setDamaged(boolean damaged) {
        this.isDamaged = damaged;
    }

}
