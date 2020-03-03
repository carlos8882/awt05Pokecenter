package org.awt05.billPc;

import org.awt05.Pokemon;
import org.awt05.PokemonContainer;
import org.awt05.trainer.Trainer;

import java.util.Scanner;

public class ConsoleBill {

    private Scanner scanner;
    private BillPc bill;

    public ConsoleBill(BillPc bill) {
        this.bill = bill;
    }

    public void run(Trainer trainer) {
        scanner = new Scanner(System.in);
        bill.turOnPC(trainer);
        while (true) {
            System.out.println("Select an action: ");
            System.out.println("1) Deposit a pokemon\n" +
                    "2) Withdraw a pokemon\n" +
                    "3) Switch Box\n" +
                    "4) See ya!: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    depositPokemon(trainer);
                    break;
                case 2:
                    withDrawPokemon(trainer);
                    break;
                case 3:
                    bill.switchBox(trainer);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Your choise is incorrect");
            }
        }
    }

    private void depositPokemon(Trainer trainer) {
        System.out.println("Select a Pokemon from your Backpack: ");
        showPokemons(trainer.getBag());
        int index = scanner.nextInt();
        Pokemon pokemonOut = trainer.getBag().remove(index);
        bill.depositPokemon(trainer, pokemonOut);
    }

    private void withDrawPokemon(Trainer trainer) {
        System.out.println("Select a Pokemon from your Box: ");
        PcBox currentBox = bill.showDefaultBox(trainer);
        showPokemons(currentBox);
        int index = scanner.nextInt();
        Pokemon pokemonIn = bill.withDrawPokemon(trainer, index);
        trainer.getBag().add(pokemonIn);
    }

    private void showPokemons(PokemonContainer pokemons) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Pokemon pokemon : pokemons) {
            builder.append("\t").append(i).append(") ")
                    .append(pokemon.getNickname())
                    .append("\n");
            i++;
        }
        System.out.println(builder.toString());
    }
}
