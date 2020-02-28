package org.awt05;

import java.io.InvalidClassException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PokeHealer {
    private int maxSize;
    private Queue<HealerBox> queueToHeal;


    public PokeHealer(int maxSize) {
        this.maxSize = maxSize;
    }

    public PokeBox initService(Trainer trainer) {
        PokeBox pokeBox = new PokeBox(maxSize);
        queueToHeal.add(new HealerBox(trainer, pokeBox));
        return pokeBox;
    }
    public void addPokemonToHeal(Trainer trainer, PokeBox pokeBox, Pokemon pokemon) throws InvalidClassException, IllegalStateException {
        if (pokemon.isDamage()) {
            verifyPokemonAbleToHeal(pokemon);
            pokeBox.add(pokemon);
        }
        else {
            throw new IllegalStateException("Your baby is not damage");
        }
    }

    private void verifyPokemonAbleToHeal(Pokemon pokemon) throws InvalidClassException {
        if (pokemon.getClass().isInstance(Poison.class)||
            pokemon.getClass().isInstance(Ground.class)) {
                throw new InvalidClassException("Te " + pokemon.getClass().getName() + "type is not able to heal yet");
        }
    }

    public void start() throws InterruptedException {
        HealerBox firstInQueue = queueToHeal.element();
        PokeBox temporalBox = firstInQueue.getPokeBox();
        heal(temporalBox);
    }

    private void heal(PokeBox pokemons) throws InterruptedException {
        for (Pokemon pokemon: pokemons) {
            pokemon.isHealed();
        }

        TimeUnit.SECONDS.sleep(3);
    }

    private void returnPokemons() {
        HealerBox firstInQueue = queueToHeal.element();
        Trainer trainer = firstInQueue.getTrainer();
        for (Pokemon pokemon: firstInQueue.getPokeBox()) {
            trainer.getBackPak().add(pokemon);
        }
    }

    public void endSession() {
        returnPokemons();
        queueToHeal.remove();
    }
}
