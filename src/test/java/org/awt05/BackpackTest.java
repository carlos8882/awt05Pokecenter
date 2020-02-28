package org.awt05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BackpackTest {

    @Test
    void whenTrainerGetsPokemonAddsToItsTeam() {
        //given
        Pokemon pokemon1 = new Pokemon(1, "mote");
        Backpack backpack = new Backpack();
        Pokemon[] pokemonTeamExpected = new Pokemon[6];
        pokemonTeamExpected[0] = pokemon1;

        //when
        backpack.addPokemon(pokemon1);

        //then
        assertArrayEquals(pokemonTeamExpected, backpack.getTeam());

    }
}
