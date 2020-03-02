package org.awt05.pokehealer;

import org.awt05.dummies.Pokemon;
import org.awt05.dummies.Trainer;
import org.awt05.PokemonContainer;

import java.util.*;

public class PokeHealer {
    private int maxSize;
    private LinkedList<Trainer> trainerQueue;
    private Map<Trainer, HealerBox> pokemonsToHeal;

    public PokeHealer(int maxSize) {
        this.maxSize = maxSize;
        this.trainerQueue = new LinkedList<>();
        this.pokemonsToHeal = new HashMap<>();
    }

    public int getQueueSize() {
        return trainerQueue.size();
    }

    public void initService(Trainer trainer) {
        if (pokemonsToHeal.containsKey(trainer)) {
            return;
        }

        trainerQueue.add(trainer);
        pokemonsToHeal.put(trainer, new HealerBox(maxSize));
    }

    public void addPokemonToHeal(Trainer trainer, Pokemon pokemon) {
        HealerBox healerBox = pokemonsToHeal.get(trainer);
        try {
            healerBox.add(pokemon);
        }
        catch (IllegalStateException exception) {
            trainer.getBackPak().add(pokemon);
            throw exception;
        }
    }

    public void start() {
        Trainer firstInTrainer = trainerQueue.element();
        HealerBox temporalBox = pokemonsToHeal.get(firstInTrainer);
        heal(temporalBox);
    }

    private void heal(HealerBox healerBox) {
        for (Pokemon pokemon: healerBox) {
            pokemon.setIsDamage(false);
        }
    }

    public PokemonContainer getHealerBox(Trainer trainer) {
        return pokemonsToHeal.get(trainer);
    }

    public void recoverPokemons(Trainer trainer) {
        HealerBox healerBox = pokemonsToHeal.get(trainer);
        healerBox.transferAll(trainer.getBackPak());
    }

    public void endService(Trainer trainer) {
        recoverPokemons(trainer);
        pokemonsToHeal.remove(trainer);
        trainerQueue.remove(trainer);
    }
}
