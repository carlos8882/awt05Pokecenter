package org.awt05;


public class PcBox {

    private Trainer currenTrainer;
    private Pokemon pokemons[];


    public PcBox(Trainer trainer) {
        this.currenTrainer = trainer;
        this.pokemons = new Pokemon[24];
    }

    public void addPokemon(Pokemon pokemon){
        pokemons[0] = pokemon;
    }

    /*public Pokemon removePokemon(String namePokemon){

        return searchPokemon(namePokemon);
    }*/

    public int searchPokemon(String namePokemon) {
        boolean isFound;
        int position = 0;
        for (int i = 0; i<pokemons.length; i++) {
            isFound = pokemons[i]
                    .getNickName()
                    .equalsIgnoreCase(namePokemon);
            if (isFound) {
                position = i;
            } else {
                throw new IllegalStateException("The pokemon has not been found");
            }
        }
        return position;
    }

}
