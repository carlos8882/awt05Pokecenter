package org.awt05;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;



public class BillPcTest {
    /*@Test
    public void whenThereIsANewTrainerRegister(){
        //given
        //Trainer expectedTrainer = new Trainer("Diego",12);
        Map<Integer , BoxList> expectedAccount = new HashMap<>();
        BoxList expectedTwoBoxesList = new BoxList();
        expectedAccount.put(12,expectedTwoBoxesList);
        boolean expectedIsRegistered = expectedAccount.containsKey(12);
        //then
        BillPc currentBillPC =new BillPc();
        currentBillPC.registerTrainer(12);
        //when
        assertEquals(expectedIsRegistered, currentBillPC.isTrainerRegistered(12));
    }*/
    /*@Test
    public void whenIGetPokemonDepositIntoBox(){
        //given
        Pokemon pokemonTest1= new Pokemon("pikachu", false, 34);
        Pokemon[] expectedBox = new Pokemon[24];
        expectedBox[0] = pokemonTest1;
        //then
        BillPc currentBillPC =new BillPc();
        currentBillPC.registerTrainer(12);
        currentBillPC.depositPokemon(12,pokemonTest1);
        //when
        assertArrayEquals(expectedBox, currentBillPC.showDefaultBox(12).getBox());
    }*/
}
