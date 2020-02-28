package org.awt05;

public interface Pokemon {
    int pokeId=0;
    String nickname="Ninguno";
    boolean isDamaged=false;

    int getId();
    String getNickname();
    boolean getIsDamaged();

    void setId(int ID);
    void setNickname(String nickname);
    void setIsDamaged(boolean damaged);
}
