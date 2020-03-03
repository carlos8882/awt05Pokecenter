package org.awt05.trainer;

import org.awt05.Pokemon;
import org.awt05.pokemons.Bellsprout;
import org.awt05.pokemons.Nidoking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Test
    void whenTwoTrainersGetCreatedWithSameName_EachGetsAnUniqueId(){
        //given
        Trainer trainer = new Trainer("Trainer1");

        //when
        Trainer trainerDifferent = new Trainer("Trainer1");

        //then
        //assert that both trainer have same names
        assertNotEquals(trainer.toString(), trainerDifferent.toString());
        //but different IDs
        assertNotEquals(trainer.getTrainerId(), trainerDifferent.getTrainerId());

    }

    @Test
    void whenGettingName_ItReturnsTheSameName() {
        //given
        String name = "Test";
        Trainer trainer = new Trainer(name);

        //when
        String name2 = trainer.getName();

        //then
        assertEquals(name, name2);
    }

    @Test
    void givenAPokemon_WhenAddingToATrainerTeam_ThenItIsCorrectlyAdded(){
        //given
        Pokemon pokemon = new Nidoking();
        Trainer trainer = new Trainer("Test");

        Trainer trainer2 = new Trainer("Test");

        //when
        trainer.getBag().add(pokemon);

        //then
        assertEquals(trainer.getBag().getSize(), 1);
        assertEquals(trainer.getBag().remove(0), pokemon);
    }

    @Test
    void givenASettedBag_WhenGettingBag_ItReturnsTheSameBag() {
        //given
        Pokemon pokemon = new Bellsprout();
        Backpack bag = new Backpack();
        bag.add(pokemon);
        Trainer trainer = new Trainer("Trainer");
        trainer.setBag(bag);

        //when
        Backpack bag2 = trainer.getBag();

        //then
        assertEquals(bag, bag2);
    }
}
