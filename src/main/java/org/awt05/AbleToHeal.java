package org.awt05;

public interface AbleToHeal {
    default void heal() {
        System.out.println("... has used HEAL!!");
    }
}
