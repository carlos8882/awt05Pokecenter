package org.awt05.pokeHealer;

import org.awt05.Pokemon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokeBox implements Iterable<Pokemon>{
    private List<Pokemon> pokemons;
    private int maxSize;

    public PokeBox(int maxSize) {
        this.pokemons = new ArrayList<Pokemon>(maxSize);
        this.maxSize = maxSize;
    }

    public void add(Pokemon pokemon) {
        if (pokemons.size() >= maxSize) {
            throw new IllegalStateException("You cannot add more Pokemons than " + maxSize);
        }

        pokemons.add(pokemon);
    }

    public Pokemon remove() {
        return pokemons.remove(0);
    }

    public int getSize() {
        return pokemons.size();
    }

    @Override
    public Iterator<Pokemon> iterator() {
        return pokemons.iterator();
    }
}
