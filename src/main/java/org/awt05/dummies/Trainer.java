package org.awt05.dummies;

import org.awt05.PokemonContainer;

public class Trainer {
    private PokemonContainer backpack;

    public Trainer() {
        this.backpack = new PokemonContainer(6);
    }

    public PokemonContainer getBackPak() {
        return backpack;
    }

    @Override
    public String toString() {
        return "Trainer";
    }
}
