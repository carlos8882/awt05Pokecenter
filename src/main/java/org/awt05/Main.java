package org.awt05;

import org.awt05.dummies.Gengar;
import org.awt05.dummies.Pokemon;
import org.awt05.dummies.Trainer;
import org.awt05.pokehealer.PokeHealer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Trainer> trainers = trainersProvider();
        PokeHealer healer = new PokeHealer(6);

        ConsoleClient client = new ConsoleClient(trainers, healer);

        client.run();
    }

    private static List<Trainer> trainersProvider() {
        List<Trainer> trainers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Trainer trainer = new Trainer();

            PokemonContainer backpack = trainer.getBackPak();
            backpack.add(new Pokemon(true));
            backpack.add(new Pokemon(true));
            backpack.add(new Pokemon(false));
            backpack.add(new Pokemon(true));
            backpack.add(new Gengar(true));

            trainers.add(trainer);
        }

        return trainers;
    }

    public static String getHello() {
        return "Hello I am in a poke center";
    }
}
