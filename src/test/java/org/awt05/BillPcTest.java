package org.awt05;

import org.awt05.billPc.BillPc;
import org.awt05.billPc.BoxList;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class BillPcTest {
    @Test
    public void whenThereIsANewTrainerRegister() {
        //given
        //Trainer expectedTrainer = new Trainer("Diego",12);
        Map<Integer, BoxList> expectedAccount = new HashMap<>();
        BoxList expectedTwoBoxesList = new BoxList();
        expectedAccount.put(12, expectedTwoBoxesList);
        boolean expectedIsRegistered = expectedAccount.containsKey(12);
        //then
        BillPc currentBillPC = new BillPc();
        currentBillPC.registerTrainer(12);
        //when
        assertEquals(expectedIsRegistered, currentBillPC.isTrainerRegistered(12));
    }

    @Test
    public void whenIGetPokemonDepositIntoBox() {
        //given
        Pokemon pokemonTest1 = new Pokemon("pikachu", false, 34);
        Pokemon[] expectedBox = new Pokemon[24];
        expectedBox[0] = pokemonTest1;
        //then
        BillPc currentBillPC = new BillPc();
        currentBillPC.registerTrainer(12);
        currentBillPC.depositPokemon(12, pokemonTest1);
        //when
        assertArrayEquals(expectedBox, currentBillPC.showDefaultBox(12).getBox());
    }

    @Test
    public void whenTrainerNeedsAPokemonWithDrawFromPcbox() {
        //given
        Pokemon pokemonTest1 = new Pokemon("pikachu", false, 34);
        Pokemon pokemonTest2 = new Pokemon("raichu", false, 46);
        Pokemon[] expectedBox = new Pokemon[24];
        expectedBox[1] = pokemonTest2;
        Pokemon expectedPokemon = expectedBox[1];
        //then
        BillPc currentBillPc = new BillPc();
        currentBillPc.registerTrainer(8);
        currentBillPc.depositPokemon(8,pokemonTest1);
        currentBillPc.depositPokemon(8, pokemonTest2);
        Pokemon currentPokemon = currentBillPc.withDrawPokemon(8, 46);
        //when
        assertEquals(expectedPokemon.getId(), currentPokemon.getId());
    }
    @Test
    public void whenTrainerNeedsAPokemonFromBox2WithDrawFromSwichedPcbox() {
        //given
        Pokemon pokemonTest1 = new Pokemon("pikachu", false, 34);
        Pokemon pokemonTest2 = new Pokemon("raichu", false, 46);
        Pokemon[] expectedBox = new Pokemon[24];
        expectedBox[0] = pokemonTest2;
        Pokemon expectedPokemon = expectedBox[0];
        //then
        BillPc currentBillPc = new BillPc();
        currentBillPc.registerTrainer(8);
        currentBillPc.depositPokemon(8,pokemonTest1);
        currentBillPc.switchBox(8);
        currentBillPc.depositPokemon(8, pokemonTest2);
        Pokemon currentPokemon = currentBillPc.withDrawPokemon(8, 46);
        //when
        assertEquals(expectedPokemon.getId(), currentPokemon.getId());
    }
}
