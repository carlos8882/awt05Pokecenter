package org.awt05.skills;

public interface AbleToHeal {
    default void heal() {
        System.out.println("... has used HEAL!!");
    }
}
