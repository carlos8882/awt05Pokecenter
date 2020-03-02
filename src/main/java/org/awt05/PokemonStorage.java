package org.awt05;

/**
 * @author: Carlos Meneses Covarrubias
 * @date: 03/02/2020
 * @version: 1.0
 */

public interface PokemonStorage {

    void addPokemon(Pokemon pokemonIn);

    Pokemon retrievePokemon(int idPokemon);

}
