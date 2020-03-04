package org.awt05.billPc;

import org.awt05.Pokemon;
import org.awt05.pokemons.Charizard;
import org.awt05.trainer.Trainer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BillPcTest {
    @Test
    public void whenThereIsANewTrainerRegister() {
        //given
        Trainer trainerTest = new Trainer("Diego");
        Pokemon pokemonTest = new Charizard();
        List<Pokemon> expectedBox = new ArrayList<>(24);
        expectedBox.add(pokemonTest);
        //then
        PcBox pcBox = new PcBox();
        pcBox.add(pokemonTest);
//        BillPc currentBillPC = new BillPc();
//        currentBillPC.depositPokemon(trainerTest,pokemonTest);
        //when
 //       assertArrayEquals((expectedBox, pcBox.iterator());


    }
}
