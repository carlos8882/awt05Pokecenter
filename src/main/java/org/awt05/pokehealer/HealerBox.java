package org.awt05.pokehealer;

import org.awt05.dummies.Ghost;
import org.awt05.dummies.Poison;
import org.awt05.dummies.Pokemon;
import org.awt05.PokemonContainer;

public class HealerBox extends PokemonContainer {
    public HealerBox(int maxSize) {
        super(maxSize);
    }

    @Override
    public void add(Pokemon pokemon) {
        if (!pokemon.isDamage()) {
            throw new IllegalStateException("Your baby is not damage");
        }
        if (pokemon instanceof Poison || pokemon instanceof Ghost) {
            throw new IllegalStateException("The <" + pokemon.getClass().getName() + "> type is not able to heal yet");
        }
        super.add(pokemon);
    }

}
