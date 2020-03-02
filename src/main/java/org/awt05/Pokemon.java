package org.awt05;

public class Pokemon {

    private int pokeId;
    private String nickname="Ninguno";
    private boolean isDamaged=false;

    public int getPokeId(){
        return pokeId;
    }
    public String getNickname(){
        return nickname;
    }
    public boolean isDamaged(){
        return isDamaged;
    }
    public void setPokeId(int pokeId) {
        this.pokeId = pokeId;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setDamaged(boolean damaged) {
        this.isDamaged = damaged;
    }

}
