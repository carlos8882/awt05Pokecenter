package org.awt05.trainer;

import org.awt05.pokemons.Chansey;
import org.junit.jupiter.api.Test;
import org.awt05.Pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackpackTest {

    @Test
    void whenTrainerGetsPokemonAddsToItsTeam() {
        //given
        Pokemon pokemon1 = new Chansey();
        Backpack backpack = new Backpack();

        //when
        backpack.add(pokemon1);

        //then
        assertEquals(backpack.remove(0), pokemon1);

    }
}
