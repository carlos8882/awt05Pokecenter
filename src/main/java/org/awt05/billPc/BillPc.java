package org.awt05.billPc;
/**
 * @author: Carlos Meneses Covarrubias
 * @date: 03/02/2020
 * @version: 1.0
 */

import org.awt05.Pokemon;
import org.awt05.exceptions.PokemonOverflowContainerException;
import org.awt05.trainer.Trainer;

import java.util.HashMap;

public class BillPc {

    private HashMap<Trainer, BoxList> accountBill;

    public BillPc() {
        accountBill = new HashMap<>();
    }

    public void turOnPC(Trainer trainer) {
        if (!isTrainerRegistered(trainer)) {
            registerTrainer(trainer);
            System.out.println("The trainer was registered successfully");
        }
        System.out.println("Hello " + trainer.getName());
    }

    public PcBox showDefaultBox(Trainer trainer) {
        return accountBill.get(trainer).getBox();
    }

    private void registerTrainer(Trainer trainer) {
        BoxList boxList = new BoxList();
        accountBill.put(trainer, boxList);
    }

    public void depositPokemon(Trainer trainer, Pokemon pokemonIn) {
        PcBox box = accountBill.get(trainer).getBox();
        try {
            box.add(pokemonIn);
            System.out.println("The pokemon was added successfully");
        } catch (PokemonOverflowContainerException e) {
            System.out.println(e.getMessage());
            System.out.println("The pokemon was not deposited");
        }
    }

    public Pokemon withDrawPokemon(Trainer trainer, int index) {
        Pokemon pokemonOut = null;
        PcBox box = accountBill.get(trainer).getBox();
        try {
            pokemonOut = box.remove(index);
            System.out.println("The pokemon was withdraw successfully");
        } catch (Exception e) {
            System.out.println("The pokemon was not founded");
        }
        return pokemonOut;
    }

    public void switchBox(Trainer trainer) {
        accountBill.get(trainer).switchBoxes();
        System.out.println("Default box was Switch");
    }

    private boolean isTrainerRegistered(Trainer trainer) {
        return accountBill.containsKey(trainer);
    }


}
