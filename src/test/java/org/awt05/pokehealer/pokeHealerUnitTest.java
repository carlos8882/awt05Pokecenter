package org.awt05.pokehealer;

import org.awt05.Pokemon;
import org.awt05.PokemonContainer;
import org.awt05.pokemons.Pikachu;
import org.awt05.trainer.Trainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class pokeHealerUnitTest {

    private Trainer trainer;
    private PokeHealer healer;

    private void setPokeHealerValues(boolean isDamage){
        trainer = new Trainer("Carlos");
        PokemonContainer backpack = trainer.getBag();
        healer = new PokeHealer(6);
        healer.initService(trainer);
        setTrainerPokemons(isDamage);

        Pokemon pokemon = trainer.getBag().remove(0);
        healer.addPokemonToHeal(trainer, pokemon);
    }

    private void setTrainerPokemons(boolean isDamage){
        PokemonContainer backpack = trainer.getBag();
        Pokemon poke = new Pikachu();
        poke.setDamaged(isDamage);
        backpack.add(poke);
     }

    @Test
    public void verifyPokeHealer(){
        //Given
        setPokeHealerValues(true);
        //When
        PokemonContainer container = healer.getHealerBox(trainer);
        healer.start();
        container = healer.getHealerBox(trainer);
        int pokemonsInContainerBefore = container.getSize();
        healer.recoverPokemons(trainer);
        PokemonContainer backpack = trainer.getBag();
        Pokemon poke = backpack.remove(0);
        boolean isDamage = poke.getIsDamaged();
        int pokemonsInContainerAfter = container.getSize();
        //Then
        assertTrue(pokemonsInContainerBefore > 0);
        assertFalse(isDamage);
        assertEquals(0, pokemonsInContainerAfter);
    }

    @Test
    public void verifyPokeHealerIsNotDamage(){
        //Given
        setPokeHealerValues(false);
        //When
        PokemonContainer container = healer.getHealerBox(trainer);
        healer.start();
        container = healer.getHealerBox(trainer);
        int pokemonsInContainerBefore = container.getSize();
        healer.recoverPokemons(trainer);
        PokemonContainer backpack = trainer.getBag();
        Pokemon poke = backpack.remove(0);
        boolean isDamage = poke.getIsDamaged();
        int pokemonsInContainerAfter = container.getSize();
        //Then
        assertTrue(pokemonsInContainerBefore > 0);
        assertFalse(isDamage);
        assertEquals(0, pokemonsInContainerAfter);
    }
}
