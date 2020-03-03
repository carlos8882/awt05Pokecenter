package org.awt05.skills;

public interface AbleToFlash {
    default void flash() {
        System.out.println("... has used FLASH!");
    }
}
