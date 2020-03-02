package org.awt05;
/**
 * @author: Carlos Meneses Covarrubias
 * @date: 03/02/2020
 * @version: 1.0
 */

import java.util.HashMap;


public class BillPc {

    private HashMap<Integer, BoxList> accountBill;

    public BillPc() {
        accountBill = new HashMap<>();
    }

    public PcBox showDefaultBox(int trainerId) {
        PcBox showBox = null;
        if (isTrainerRegistered(trainerId)) {
            showBox = accountBill.get(trainerId).getBox();
        } else {
            System.out.println("Unregistered trainer, register please");
        }
        return showBox;
    }

    public void registerTrainer(int trainerId) {
        if (!isTrainerRegistered(trainerId)) {
            BoxList boxList = new BoxList();
            accountBill.put(trainerId, boxList);
            System.out.println("The trainer was registered successfully");
        } else {
            System.out.println("The trainer has already registered");
        }
    }

    public void depositPokemon(int trainerID, Pokemon pokemonIn) {
        if (isTrainerRegistered(trainerID)) {
            PcBox box = accountBill.get(trainerID).getBox();
            if (box.isFreeSpaceInsideBox()) {
                box.addPokemon(pokemonIn);
                System.out.println("The pokemon was added successfully");
            } else {
                System.out.println("The pokemon was not deposited,There is not available space");
            }
        } else {
            System.out.println("Unregistered trainer, register please");
        }
    }

    public Pokemon withDrawPokemon(int trainerId, int pokemonID) {
        Pokemon pokemonOut = null;
        if (isTrainerRegistered(trainerId)) {
            PcBox box = accountBill.get(trainerId).getBox();
            if (box.isPokemonFoundedInsideBox(pokemonID)) {
                pokemonOut = box.retrievePokemon(pokemonID);
                System.out.println("The pokemon was withdraw successfully");
            } else {
                System.out.println("The pokemon was not founded");
            }
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
