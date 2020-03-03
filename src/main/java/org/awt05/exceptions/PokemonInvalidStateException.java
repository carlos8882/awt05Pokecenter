package org.awt05.exceptions;

import org.awt05.Pokemon;

public class PokemonInvalidStateException extends RuntimeException {

    public PokemonInvalidStateException(Pokemon pokemon) {
        super(pokemon.getNickname() + " has the state <Damage: " + pokemon.getIsDamaged() + ">");
    }
}
