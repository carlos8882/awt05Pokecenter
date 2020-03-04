package org.awt05.billPc;

import org.awt05.Pokemon;
import org.awt05.pokemons.Chansey;
import org.awt05.trainer.Backpack;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PcBoxTest {
    @Test
    void whenPcBoxGetsPokemonRetriveToItsTeam() {
        //given
        Pokemon pokemon1 = new Chansey();
        PcBox pcBox = new PcBox();

        //when
        pcBox.add(pokemon1);

        //then
        assertEquals(pcBox.remove(0), pokemon1);

    }
}
