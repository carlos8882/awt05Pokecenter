package org.awt05.exceptions;

import org.awt05.trainer.Trainer;

public class NoSuchPokemonException extends Exception {

    public NoSuchPokemonException(Trainer trainer) {
        super(trainer.getName() + "does not have the pokemon wanted.");
    }
}
