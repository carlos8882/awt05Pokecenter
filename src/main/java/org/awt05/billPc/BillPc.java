package org.awt05.billPc;
/**
 * @author: Carlos Meneses Covarrubias
 * @date: 03/02/2020
 * @version: 1.0
 */

import org.awt05.Pokemon;
import org.awt05.Trainer;
import org.awt05.exceptions.PokemonInvalidStateException;
import org.awt05.exceptions.PokemonOverflowContainerException;

import java.util.HashMap;


public class BillPc {

    private HashMap<Integer, BoxList> accountBill;

    public BillPc() {
        accountBill = new HashMap<>();
    }

    public void turOnPC(Trainer trainer) {
        if (!isTrainerRegistered(trainer.getId())) {
            registerTrainer(trainer.getId());
            System.out.println("The trainer was registered successfully");
        }
        System.out.println("Hello " + trainer.getName());
    }

    public PcBox showDefaultBox(int trainerId) {
        return accountBill.get(trainerId).getBox();
    }

    private void registerTrainer(int trainerId) {
        BoxList boxList = new BoxList();
        accountBill.put(trainerId, boxList);
    }

    public void depositPokemon(int trainerID, Pokemon pokemonIn) {
        PcBox box = accountBill.get(trainerID).getBox();
        try {
            box.add(pokemonIn);
            System.out.println("The pokemon was added successfully");
        } catch (PokemonOverflowContainerException e) {
            System.out.println(e.getMessage());
            System.out.println("The pokemon was not deposited");
        }
    }

    public Pokemon withDrawPokemon(int trainerId, int index) {
        Pokemon pokemonOut = null;
        PcBox box = accountBill.get(trainerId).getBox();
        try {
            pokemonOut = box.remove(index);
            System.out.println("The pokemon was withdraw successfully");
        } catch (Exception e) {
            System.out.println("The pokemon was not founded");
        }
        return pokemonOut;
    }

    public void switchBox(int trainerId) {
        accountBill.get(trainerId).switchBoxes();
        System.out.println("Default box was Switch");
    }

    public boolean isTrainerRegistered(int trainerId) {
        return accountBill.containsKey(trainerId);
    }


}
