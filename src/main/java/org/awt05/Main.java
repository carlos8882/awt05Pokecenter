package org.awt05;

import org.awt05.pokemons.Gengar;
import org.awt05.trainer.Trainer;
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
            Trainer trainer = new Trainer("Trainer");

            PokemonContainer backpack = trainer.getBag();
            backpack.add(new Pokemon());
            backpack.add(new Pokemon());
            backpack.add(new Pokemon());
            backpack.add(new Pokemon());
            backpack.add(new Gengar());

            trainers.add(trainer);
        }

        return trainers;
    }

}
