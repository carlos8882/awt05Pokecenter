package org.awt05;

import org.awt05.exceptions.NoSuchPokemonException;

public class Backpack {
    private Pokemon[] pokemonTeam;

    public Backpack() {
        this.pokemonTeam = new Pokemon[6];
    }

    private int searchPokemonPosition(int iD) throws NoSuchPokemonException {
        boolean isPokemon;
        int position = -1;
        for (int i = 0; i < pokemonTeam.length; i++) {
            isPokemon = pokemonTeam[i].getiD() == iD;
            if (isPokemon) {
                position = i;
                break;
            }
        }
        if (position < 0) {
            throw new NoSuchPokemonException("The pokemon is not in the bag.");
        } else {
            System.out.println("Pokemon selected.");
        }
        return position;
    }

    private int searchFreePokemonSpace() throws NoSuchPokemonException {
        boolean isFree;
        int position = -1;
        for (int i = 0; i < pokemonTeam.length; i++) {
            isFree = pokemonTeam[i] == null;
            if (isFree) {
                position = i;
                break;
            }
        }
        if (position < 0) {
            throw new NoSuchPokemonException("There is not enough space in the bag.");
        } else {
            System.out.println("Pokemon can fit.");
        }
        return position;
    }

    public void addPokemon(Pokemon pokemon) {
        try {
            pokemonTeam[searchFreePokemonSpace()] = pokemon;
        } catch (NoSuchPokemonException e) {
            e.printStackTrace();
        }
    }

    public Pokemon retrievePokemon(int iD) {
        int position = 0;
        try {
            position = searchPokemonPosition(iD);
        } catch (NoSuchPokemonException e) {
            e.printStackTrace();
        }
        Pokemon pokemonReturn = pokemonTeam[position];
        pokemonTeam[position] = null;
        return pokemonReturn;
    }

    public Pokemon[] getTeam() {
        return this.pokemonTeam;
    }

}
