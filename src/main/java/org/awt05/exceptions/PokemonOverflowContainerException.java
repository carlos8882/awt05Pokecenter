package org.awt05.exceptions;

public class PokemonOverflowContainerException extends RuntimeException {

    public PokemonOverflowContainerException(int maxSize) {
        super("You cannot add more pokemons than " + maxSize);
    }
}
