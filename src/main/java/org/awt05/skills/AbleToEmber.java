package org.awt05.skills;

import org.awt05.Pokemon;

public interface AbleToEmber extends Pokemon {
    public default void ember() {
        System.out.println("... has used Ember!!");
    }
}
