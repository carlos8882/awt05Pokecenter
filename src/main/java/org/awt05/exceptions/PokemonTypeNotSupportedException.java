package org.awt05.exceptions;

import org.awt05.Pokemon;

public class PokemonTypeNotSupportedException extends RuntimeException {

    public PokemonTypeNotSupportedException(Pokemon pokemon) {
        super("The <" + pokemon.getClass().getSimpleName() + "> type is not able to heal yet");
    }
}

