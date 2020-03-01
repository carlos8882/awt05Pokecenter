package org.awt05.pokeHealer;

import org.awt05.Gengar;
import org.awt05.Pokemon;
import org.awt05.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InvalidClassException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PokeHealerOneTrainerTest {
    private PokeHealer healer;
    PokeBox box;

    @BeforeEach
    private void init() {
        healer = new PokeHealer(6);
        box = healer.initService(new Trainer());
    }

    @Test
    public void getEmptyBoxWhenInitHealerTest() {
        PokeBox box = healer.initService(new Trainer());

        assertEquals(0, box.getSize());
    }

    @ParameterizedTest
    @MethodSource("pokemonsAndSizeProvider")
    public void addPokemonsToHealTest(int boxSize, List<Pokemon> pokemons) throws InvalidClassException, IllegalStateException {

        for (Pokemon pokemon: pokemons) {
            healer.addPokemonToHeal(box, pokemon);
        }

        assertEquals(boxSize, box.getSize());
    }

    @ParameterizedTest
    @MethodSource("somePokemonsNotDamageProvider")
    public void addPokemonsNotDamageTest(List<Pokemon> pokemons) {
        assertThrows(IllegalStateException.class,
                () -> {
                    for (Pokemon pokemon: pokemons) {
                        healer.addPokemonToHeal(box, pokemon);
                    }
                });
    }

    @ParameterizedTest
    @MethodSource("invalidPokemonsProvider")
    public void addPokemonsInvalidClassTest(Pokemon pokemon) {

        assertThrows (InvalidClassException.class,
                () -> healer.addPokemonToHeal(box, pokemon));
    }

    @ParameterizedTest
    @MethodSource("pokemonsProvider")
    public void healPokemonsTest(List<Pokemon> pokemons) throws InvalidClassException, InterruptedException {
        for (Pokemon pokemon: pokemons) {
            healer.addPokemonToHeal(box, pokemon);
        }

        for (Pokemon pokemon : box) {
            assertTrue(pokemon.isDamage());
        }

        healer.start();

        for (Pokemon pokemon : box) {
            assertFalse(pokemon.isDamage());
        }
    }


    private static Stream<Arguments> pokemonsProvider() {
        return Stream.of(
                arguments(Collections.singletonList(new Pokemon(true))),
                arguments(Arrays.asList(new Pokemon(true), new Pokemon(true))),
                arguments(Arrays.asList(new Pokemon(true), new Pokemon(true), new Pokemon(true), new Pokemon(true), new Pokemon(true), new Pokemon(true)))
        );
    }

    private static Stream<Arguments> somePokemonsNotDamageProvider() {
        return Stream.of(
                arguments(Collections.singletonList(new Pokemon(false))),
                arguments(Collections.singletonList(new Gengar(false))),
                arguments(Arrays.asList(new Pokemon(true), new Pokemon(true), new Pokemon(true), new Pokemon(true), new Pokemon(true), new Pokemon(false)))
        );
    }

    private static Stream<Arguments> pokemonsAndSizeProvider() {
        return Stream.of(
                arguments(1, Collections.singletonList(new Pokemon(true))),
                arguments(3, Arrays.asList(new Pokemon(true), new Pokemon(true), new Pokemon(true)))
        );
    }

    private static Stream<Arguments> invalidPokemonsProvider() {
        return Stream.of(
                arguments(new Gengar(true))
        );
    }
}