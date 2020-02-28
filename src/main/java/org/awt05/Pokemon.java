package org.awt05;

public interface Pokemon {
    int id=0;
    String nickname="Ninguno";
    boolean isDamaged=false;

    int getId();
    String getNickname();
    boolean getIsDamaged();

    void setId(int id);
    void setNickname(String nickname);
    void setIsDamaged(boolean damaged);
}
