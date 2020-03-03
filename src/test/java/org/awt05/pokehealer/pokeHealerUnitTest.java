package org.awt05.pokehealer;

import org.awt05.PokemonContainer;
import org.awt05.dummies.Pokemon;
import org.awt05.dummies.Trainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class pokeHealerUnitTest {

    private Trainer trainer;
    private PokeHealer healer;

    private void setPokeHealerValues(boolean isDamage){
        trainer = new Trainer();
        PokemonContainer backpack = trainer.getBackPak();
        healer = new PokeHealer(6);
        healer.initService(trainer);
        setTrainerPokemons(isDamage);

        Pokemon pokemon = trainer.getBackPak().remove(0);
        healer.addPokemonToHeal(trainer, pokemon);
    }

    private void setTrainerPokemons(boolean isDamage){
        PokemonContainer backpack = trainer.getBackPak();
        backpack.add(new Pokemon(isDamage));
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
        PokemonContainer backpack = trainer.getBackPak();
        Pokemon poke = backpack.remove(0);
        boolean isDamage = poke.isDamage();
        int pokemonsInContainerAfter = container.getSize();
        //Then
        assertTrue(pokemonsInContainerBefore > 0);
        assertFalse(isDamage);
        assertTrue(pokemonsInContainerAfter == 0);
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
        PokemonContainer backpack = trainer.getBackPak();
        Pokemon poke = backpack.remove(0);
        boolean isDamage = poke.isDamage();
        int pokemonsInContainerAfter = container.getSize();
        //Then
        assertTrue(pokemonsInContainerBefore > 0);
        assertFalse(isDamage);
        assertTrue(pokemonsInContainerAfter == 0);
    }
}
