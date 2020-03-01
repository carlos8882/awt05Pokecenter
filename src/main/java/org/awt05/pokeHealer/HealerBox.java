package org.awt05.pokeHealer;

import org.awt05.Trainer;

public class HealerBox {
    private Trainer trainer;
    private PokeBox pokemons;

    public HealerBox(Trainer trainer, PokeBox pokemons) {
        this.trainer = trainer;
        this.pokemons = pokemons;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public PokeBox getPokeBox() {
        return pokemons;
    }
}
