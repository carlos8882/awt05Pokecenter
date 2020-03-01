package org.awt05.pokeHealer;

import org.awt05.Ghost;
import org.awt05.Poison;
import org.awt05.Pokemon;
import org.awt05.Trainer;

import java.io.InvalidClassException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PokeHealer {
    private int maxSize;
    private Queue<HealerBox> queueToHeal;


    public PokeHealer(int maxSize) {

        this.maxSize = maxSize;
        this.queueToHeal = new LinkedList<>();
    }

    public int getQueueSize() {
        return queueToHeal.size();
    }

    public PokeBox initService(Trainer trainer) {
        PokeBox pokeBox = new PokeBox(maxSize);
        queueToHeal.add(new HealerBox(trainer, pokeBox));
        return pokeBox;
    }

    public void addPokemonToHeal(PokeBox pokeBox, Pokemon pokemon) throws InvalidClassException, IllegalStateException {
        if (pokemon.isDamage()) {
            verifyPokemonAbleToHeal(pokemon);
            pokeBox.add(pokemon);
        }
        else {
            throw new IllegalStateException("Your baby is not damage");
        }
    }

    private void verifyPokemonAbleToHeal(Pokemon pokemon) throws InvalidClassException {
        if (pokemon instanceof Poison ||
            pokemon instanceof Ghost
            ) {
                throw new InvalidClassException("The <" + pokemon.getClass().getName() + "> type is not able to heal yet");
        }
    }

    public void start() throws InterruptedException {
        HealerBox firstInQueue = queueToHeal.element();
        PokeBox temporalBox = firstInQueue.getPokeBox();

        if (temporalBox.getSize() == 0) {
            endSession(temporalBox);
            return;
        }

        heal(temporalBox);
    }

    private void heal(PokeBox pokemons) throws InterruptedException {
        for (Pokemon pokemon: pokemons) {
            pokemon.isHealed();
        }

        TimeUnit.SECONDS.sleep(3);
    }

    public List<Pokemon> returnPokemons(PokeBox box) {
        List<Pokemon> pokemons = new ArrayList<>();
        int boxSize = box.getSize();
        for (int i = 0; i < boxSize; i++) {
            pokemons.add(box.remove());
        }
        return pokemons;
    }

    public List<Pokemon> endSession(PokeBox box) {
        List<Pokemon> pokemons = returnPokemons(box);
        queueToHeal.remove();
        return pokemons;
    }
}
