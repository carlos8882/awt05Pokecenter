package org.awt05;

public interface AbleToFlash {
    default void flash() {
        System.out.println("... has used FLASH!");
    }
}
