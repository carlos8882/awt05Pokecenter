package org.awt05;


public class PcBox {

    private Pokemon[] pokemonGang;

    public PcBox() {
        this.pokemonGang = new Pokemon[24];
    }

    public Pokemon[] getBox(){
        return this.pokemonGang;
    }

    public Pokemon switchPokemon(Pokemon pokemonIn, int idPokemon) {
        Pokemon pokemonOut = retrievePokemon(idPokemon);
        addPokemon(pokemonIn);
        return pokemonOut;
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

    private int searchPokemon(int idPokemon) {
        int pokePosition = -1;
        for (int i = 0; i < pokemonGang.length; i++) {
            if (pokemonGang[i].getId() == idPokemon) {
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

    private int searchFreePokemonSpace() {
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
    public boolean isFreeSpaceInsideBox(){
        return searchFreePokemonSpace() != -1;
    }
    public boolean isPokemonFoundedInsideBox(int pokemonId){
        return searchPokemon(pokemonId) != -1;
    }

}
