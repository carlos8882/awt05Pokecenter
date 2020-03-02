package org.awt05;

/**
 * @author: Carlos Meneses Covarrubias
 * @date: 03/02/2020
 * @version: 1.0
 */

public class PokemonBoxStorage {

    protected Pokemon[] pokemonGang;

    public Pokemon[] getBox() {
        return this.pokemonGang;
    }

    public void addPokemon(Pokemon pokemonIn) {
        try {
            pokemonGang[searchFreePokemonSpace()] = pokemonIn;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public Pokemon retrievePokemon(int idPokemon) {
        int position = 0;
        try {
            position = searchPokemon(idPokemon);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        Pokemon pokemonOut = pokemonGang[position];
        pokemonGang[position] = null;
        return pokemonOut;
    }

    protected int searchPokemon(int idPokemon) {
        int pokePosition = -1;
        for (int i = 0; i < pokemonGang.length; i++) {
            if (pokemonGang[i] != null && pokemonGang[i].getId() == idPokemon) {
                pokePosition = i;
                break;
            }
        }
        if (pokePosition < 0) {
            throw new IllegalStateException("The pokemon has not been found");
        } else {
            System.out.println("The pokemon has been bound");
        }
        return pokePosition;
    }

    protected int searchFreePokemonSpace() {
        int freePosition = -1;
        for (int i = 0; i < pokemonGang.length; i++) {
            if (pokemonGang[i] == null) {
                freePosition = i;
                break;
            }
        }
        if (freePosition < 0) {
            throw new IllegalStateException("There is no free position found");
        } else {
            System.out.println("Free position founded");
        }

        return freePosition;
    }

    public boolean isFreeSpaceInsideBox() {
        return searchFreePokemonSpace() != -1;
    }

    public boolean isPokemonFoundedInsideBox(int pokemonId) {
        return searchPokemon(pokemonId) != -1;
    }
}
