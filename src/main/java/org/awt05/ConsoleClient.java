package org.awt05;

import org.awt05.trainer.Trainer;
import org.awt05.exceptions.PokemonInvalidStateException;
import org.awt05.exceptions.PokemonOverflowContainerException;
import org.awt05.exceptions.PokemonTypeNotSupportedException;
import org.awt05.pokehealer.PokeHealer;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleClient {

    public static final String YES_ANSWER = "y";
    private Scanner scanner;
    private List<Trainer> trainers;
    private PokeHealer healer;

    public ConsoleClient(List<Trainer> trainers, PokeHealer healer) {
        this.trainers = trainers;
        this.healer = healer;
    }

    public void run() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select trainer:");
            System.out.println("0) To quit.");
            for (int i = 1; i <= trainers.size(); i++) {
                int index = i - 1;
                System.out.println(i + ") " + trainers.get(index)
                                                       .toString());
            }
            int input = scanner.nextInt();

            if (input == 0) {
                break;
            }

            try {
                Trainer activeTrainer = trainers.get(input - 1);
                selectPlace(activeTrainer);
            } catch (Exception ex) {
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
                    enterToContinue();
                    break;
            }
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
                    showPokemons(trainer.getBag());
                    enterToContinue();
                    break;
                case 2:
                    showPokemons(healer.getHealerBox(trainer));
                    enterToContinue();
                    break;
                case 3:
                    askForInserting(trainer);
                    enterToContinue();
                    break;
                case 4:
                    insertAll(trainer);
                    enterToContinue();
                    break;
                case 5:
                    healer.recoverPokemons(trainer);
                    System.out.println("Pokemons were recovered");
                    enterToContinue();
                    break;
                case 6:
                    healer.endService(trainer);
                    System.out.println("Pokemons to heal <" + healer.getHealerBox(trainer).getSize() + ">");
                    enterToContinue();
                    return true;
                case 7:
                    return true;
                case 8:
                    return false;
                case 9:
                    healer.start();
                    System.out.println("Pokemons were healed");
                    enterToContinue();
                    break;
                default:
                    System.out.println("Invalid command.");
                    enterToContinue();
                    break;
            }
        }
    }

    public void askForInserting(Trainer trainer) {
        String answer = YES_ANSWER;
        while (Objects.equals(answer, YES_ANSWER)) {
            if (!showPokemons(trainer.getBag())) {
                return;
            }
            System.out.println("Insert pokemon number:");
            int index = scanner.nextInt();
            insertPokemon(trainer, index);
            System.out.println("Do you want to insert another? [Y]es/");
            answer = scanner.next();
        }
    }

    private void insertAll(Trainer trainer) {
        int size = trainer.getBag().getSize();
        for (int i = 0; i < size; i++) {
            insertPokemon(trainer, 0);
        }
        System.out.println("Your pokemons were inserted successfully");
    }

    private void insertPokemon(Trainer trainer, int index) {
        try {
            Pokemon pokemon = trainer.getBag().remove(index);
            healer.addPokemonToHeal(trainer, pokemon);
        } catch (PokemonInvalidStateException | PokemonTypeNotSupportedException | PokemonOverflowContainerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private boolean showPokemons(Iterable<Pokemon> pokemons) {
        Iterator<Pokemon> iterator = pokemons.iterator();
        StringBuilder builder = new StringBuilder();
        boolean isEnable;

        if (!iterator.hasNext()) {
            builder.append("Not pokemons to show.");
            isEnable = false;
        } else {
            for (int i = 0; iterator.hasNext(); i++) {
                Pokemon pokemon = iterator.next();
                builder.append("\t").append(i).append(") ")
                        .append(pokemon.toString()).append(", ")
                        .append("damaged: ").append(pokemon.getIsDamaged())
                        .append("\n");
            }
            isEnable = true;
        }
        System.out.println(builder.toString());
        return isEnable;
    }

    private void enterToContinue() {
        System.out.println("Press <Enter> to continue.");
        scanner.nextLine();
        scanner.nextLine();
    }
}
