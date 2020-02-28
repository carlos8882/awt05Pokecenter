package org.awt05;


public class PcBox {

    private Trainer currenTrainer;
    private Pokemon[] pokemonGang;


    public PcBox(Trainer trainer) {
        this.currenTrainer = trainer;
        this.pokemonGang = new Pokemon[24];
    }

    public Pokemon switchPokemon(Pokemon pokemonIn, int idPokemon){
        Pokemon pokemonOut = retrievePokemon(idPokemon);
        addPokemon(pokemonIn);
        return pokemonOut;
    }

    public void addPokemon(Pokemon pokemon){
        try {
            pokemonGang[searchFreePokemonSpace()] = pokemon;
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
    }

    public Pokemon retrievePokemon(int idPokemon){
            int position = 0;
            try {
                position = searchPokemon(idPokemon);
            }catch (IllegalStateException e){
                e.printStackTrace();
            }
            Pokemon pokemonToRetrieve = pokemonGang[position];
            pokemonGang[position] = null;
        return pokemonToRetrieve;
    }

    public int searchPokemon(int idPokemon) {
        boolean isFound;
        int position = 0;
        for (int i = 0; i< pokemonGang.length; i++) {
            isFound = pokemonGang[i].getId() == idPokemon;
            if (isFound) {
                position = i;
                break;
            } else {
                throw new IllegalStateException("The pokemon has not been found");
            }
        }
        return position;
    }
    public int searchFreePokemonSpace(){
        boolean isFree;
        int freePosition = 0;
        for(int i = 0; i< pokemonGang.length; i++){
            isFree = pokemonGang[i] == null;
            if (isFree){
                freePosition = i;
                break;
            }else {
                throw new IllegalStateException("There is no free position found");
            }
        }
        return freePosition;
    }

}
