package org.awt05;

public interface AbleToMetronome {
    default void metronome() {
        System.out.println("... has used METRONOME!!");
    }
}
