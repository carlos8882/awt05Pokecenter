package org.awt05.pokemons;

import org.awt05.types.Fire;
import org.awt05.types.Flying;

public class Charizard  implements Fire, Flying {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getNickname() {
        return null;
    }

    @Override
    public boolean getIsDamaged() {
        return false;
    }

    @Override
    public void setId(int ID) {

    }

    @Override
    public void setNickname(String nickname) {

    }

    @Override
    public void setIsDamaged(boolean damaged) {

    }
}
