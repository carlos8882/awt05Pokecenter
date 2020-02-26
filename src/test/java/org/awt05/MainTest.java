package org.awt05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void whenIGetHelloThenCorrectHelloMessageIsReturned() {
        // Given
        String expectedHelloMessage = "Hello I am in a poke center";

        // When
        String currentHelloMessage = Main.getHello();

        //Then
        assertEquals(expectedHelloMessage, currentHelloMessage);
    }
}
