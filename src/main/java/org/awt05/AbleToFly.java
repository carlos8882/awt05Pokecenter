package org.awt05;

public interface AbleToFly {

    default void fly() {
        System.out.println("... has used FLY!!");
    }

}
