package org.awt05;

import org.awt05.billPc.PcBox;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PcBoxTest {
    @Test
    public void whenPcBoxGetPokemonAddToGang(){
        //given
        Pokemon pokemonTest1= new Pokemon("pikachu", false, 34);
        Pokemon[] expectedBox = new Pokemon[24];
        expectedBox[0] = pokemonTest1;
        //when
        PcBox currentBox = new PcBox();
        currentBox.addPokemon(pokemonTest1);

        //then
        assertArrayEquals(expectedBox, currentBox.getBox());
    }

}
