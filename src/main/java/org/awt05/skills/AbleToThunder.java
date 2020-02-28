package org.awt05.skills;

public interface AbleToThunder {
    default void thunder() {
        System.out.println("... has used THUNDER!!");
    }
}
