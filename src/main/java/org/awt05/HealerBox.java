package org.awt05;

import java.util.List;

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
