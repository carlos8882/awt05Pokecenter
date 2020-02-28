package org.awt05;

public interface AbleToPoison {
    default void poison() {
        System.out.println("... has used Poison!!");
    }
}
