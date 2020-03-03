package org.awt05.trainer;

import org.awt05.dummies.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    void GivenASettedName_WhenGettingName_ItReturnsTheSameName() {
        //given
        String name = "Test";
        Trainer trainer = new Trainer("name");
        trainer.setName(name);

        //when
        String name2 = trainer.getName();

        //then
        assertEquals(name, name2);
    }

    @Test
    void GivenASettedBag_WhenGettingBag_ItReturnsTheSameBag() {
        //given
        Pokemon pokemon = new Pokemon(false);
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
