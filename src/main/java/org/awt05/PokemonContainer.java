package org.awt05;

import org.awt05.exceptions.PokemonOverflowContainerException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokemonContainer implements Iterable<Pokemon> {
    private List<Pokemon> pokemons;
    private int maxSize;

    public PokemonContainer(int maxSize) {
        this.pokemons = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public void add(Pokemon pokemon) {
        if (pokemons.size() >= maxSize) {
            throw new PokemonOverflowContainerException(maxSize);
        }
        pokemons.add(pokemon);
    }

    protected void clear() {
        pokemons.clear();
    }

    public void transferAll(PokemonContainer contaniner) {
        for (Pokemon pokemon : this) {
            contaniner.add(pokemon);
        }
        clear();
    }

    public Pokemon remove(int index) {
        return pokemons.remove(index);
    }

    public int getSize() {
        return pokemons.size();
    }

    @Override
    public Iterator<Pokemon> iterator() {
        return pokemons.iterator();
    }
}
