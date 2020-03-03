
package org.awt05.pokemons;


import org.awt05.Pokemon;
import org.awt05.skills.AbleToSurf;
import org.awt05.types.Normal;

public class Snorlax extends Pokemon implements Normal, AbleToSurf {
    @Override
    public void surf() {
        System.out.println("... has used WALKING INTO WATER!!");
    }
}
