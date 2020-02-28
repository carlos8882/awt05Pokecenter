package org.awt05.skills;

public interface AbleToPoison {
    default void poison() {
        System.out.println("... has used Poison!!");
    }
}
