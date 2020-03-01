package org.awt05.pokeHealer;

import org.awt05.Trainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PokeHealerTest {

    private static PokeHealer healer;
    private static Trainer trainer1;
    private static Trainer trainer2;

    @BeforeAll
    private static void initAll() {
        healer = new PokeHealer(6);
        trainer1 = new Trainer();
        trainer2 = new Trainer();
    }

    @ParameterizedTest
    @MethodSource("trainersProvider")
    public void addTrainerToQueueTest(int queueSize, List<Trainer> trainers) {

        for (Trainer trainer: trainers) {
            healer.initService(trainer);
        }

        assertEquals(queueSize, healer.getQueueSize());
    }

    private static Stream<Arguments> trainersProvider() {
        return Stream.of(
                arguments(1, Collections.singletonList(trainer1)),
                arguments(3, Arrays.asList(trainer1, trainer2)),
                arguments(6, Arrays.asList(trainer1, trainer2, new Trainer()))
        );
    }
}
