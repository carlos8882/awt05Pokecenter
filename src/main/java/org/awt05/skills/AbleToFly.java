package org.awt05.skills;

public interface AbleToFly {

    default void fly() {
        System.out.println("... has used FLY!!");
    }

}
