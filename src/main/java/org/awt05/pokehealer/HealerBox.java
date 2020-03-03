package org.awt05.pokehealer;

import org.awt05.dummies.Ghost;
import org.awt05.dummies.Poison;
import org.awt05.dummies.Pokemon;
import org.awt05.PokemonContainer;
import org.awt05.exceptions.PokemonInvalidStateException;
import org.awt05.exceptions.PokemonTypeNotSupportedException;

/**
 *  HealerBox is a pokemon container that avoid insert some types of pokemons (Poison, Ghost)
 *  and pokemons that are not damage.
 *
 *  @author Lucero Quiroga Perez
 */

public class HealerBox extends PokemonContainer {
    public HealerBox(int maxSize) {
        super(maxSize);
    }

    @Override
    public void add(Pokemon pokemon) {
        if (!pokemon.isDamage()) {
            throw new PokemonInvalidStateException(pokemon);
        }
        if (pokemon instanceof Poison || pokemon instanceof Ghost) {
            throw new PokemonTypeNotSupportedException(pokemon);
        }
        super.add(pokemon);
    }

}
