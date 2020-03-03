package org.awt05;


import org.awt05.exceptions.PokemonOverflowContainerException;

import java.util.ArrayList;
import java.util.List;

public class PokemonStorage {
    private List<Pokemon> pokemons;
    private int maxSize;

    public PokemonStorage(int maxSize) {
        this.pokemons = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public void add(Pokemon pokemon) {
        if (pokemons.size() >= maxSize) {
            throw new PokemonOverflowContainerException(maxSize);
        }
        pokemons.add(pokemon);
    }

    public Pokemon remove(int index) {
        return pokemons.remove(index);
    }

    public int getSize() {
        return pokemons.size();
    }
}
