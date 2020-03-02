package org.awt05;

import org.awt05.dummies.Pokemon;
import org.awt05.dummies.Trainer;
import org.awt05.pokehealer.PokeHealer;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ConsoleClient {

    private Scanner scanner;
    private List<Trainer> trainers;
    private PokeHealer healer;

    public ConsoleClient(List<Trainer> trainers, PokeHealer healer) {
        this.trainers = trainers;
        this.healer = healer;
    }

    public void run() {
        scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Select trainer:");
            System.out.println("0) To quit.");
            for (int i = 1; i <= trainers.size() ; i++) {
                int index = i - 1;
                System.out.println(i + ") " + trainers.get(index));
            }
            int input = scanner.nextInt();

            if (input == 0) {
                break;
            }

            try {
                Trainer activeTrainer = trainers.get(input - 1);
                selectPlace(activeTrainer);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Good bye.");
    }

    private void selectPlace(Trainer activeTrainer) {
        boolean isActive = true;
        while (isActive) {
            System.out.println("Select place:\n\t1) PokeHealer \n\t2) Others places \n\t3) Back");
            int placeNumber = scanner.nextInt();

            switch (placeNumber) {
                case 1:
                    isActive = runPokeHealer(activeTrainer);
                    break;
                case 2:
                case 3:
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid place number.");
                    break;
            }
            enterToContinue();
        }
    }

    private boolean runPokeHealer(Trainer trainer) {
        healer.initService(trainer);
        while (true) {
            System.out.println("PokeHealer enable, select an action:");
            System.out.println("\t1) Show pokemons in backpack");
            System.out.println("\t2) Show pokemons in HealerBox");
            System.out.println("\t3) Insert a pokemon to heal");
            System.out.println("\t4) Insert all pokemons");
            System.out.println("\t5) Recover pokemons");
            System.out.println("\t6) End Service");
            System.out.println("\t7) Back");
            System.out.println("\t8) Change the trainers");
            System.out.println("---------------------------------------");
            System.out.println("\t9) Heal");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    showPokemons(trainer.getBackPak());
                    break;
                case 2:
                    showPokemons(healer.getHealerBox(trainer));
                    break;
                case 3:
                    showPokemons(trainer.getBackPak());
                    System.out.println("Insert pokemon number:");
                    int index = scanner.nextInt();
                    insertPokemon(trainer, index);
                    break;
                case 4:
                    insertAll(trainer);
                    break;
                case 5:
                    healer.recoverPokemons(trainer);
                    break;
                case 6:
                    healer.endService(trainer);
                    return true;
                case 7:
                    return true;
                case 8:
                    return false;
                case 9:
                    healer.start();
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
            enterToContinue();
        }
    }

    private void insertAll(Trainer trainer) {
        int size = trainer.getBackPak().getSize();
        for (int i = 0; i < size; i++) {
            insertPokemon(trainer, 0);
        }
    }

    private void insertPokemon(Trainer trainer, int index) {
        try {
            Pokemon pokemon = trainer.getBackPak().remove(index);
            healer.addPokemonToHeal(trainer, pokemon);
        }
        catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void showPokemons(Iterable<Pokemon> pokemons) {
        Iterator<Pokemon> iterator = pokemons.iterator();
        StringBuilder builder = new StringBuilder();

        if (!iterator.hasNext()) {
            builder.append("Not pokemons to show.");
        }
        else {
            for (int i = 0; iterator.hasNext(); i++) {
                Pokemon pokemon = iterator.next();
                builder.append("\t").append(i).append(") ")
                        .append(pokemon.toString()).append(", ")
                        .append("is damage: ").append(pokemon.isDamage())
                        .append("\n");
            }
        }
        System.out.println(builder.toString());
    }

    private void enterToContinue() {
        System.out.println("Press to continue:");
        scanner.nextByte();
    }
}
