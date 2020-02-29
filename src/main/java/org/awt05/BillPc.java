package org.awt05;

import java.util.HashMap;

public class BillPc {

    private HashMap<Integer, BoxList> accountBill;

    public BillPc(){
        accountBill = new HashMap<>();
    }
    public void registerTrainer(int trainerId){
        if (isRegistered(trainerId)) {
            BoxList boxList = new BoxList();
            accountBill.put(trainerId, boxList);
            System.out.println("The trainer was registered successfully");
        }else {
            System.out.println("The trainer has already registered");
        }
    }

    public void depositPokemon(int trainerID, Pokemon pokemonIn){
        PcBox box = accountBill.get(trainerID).getBox();
        if (box.isFreeSpaceInsideBox()){
            box.addPokemon(pokemonIn);
            System.out.println("The pokemon was added successfully");
        }else {
            System.out.println("The pokemon was not deposited,There is not available space");
        }
    }
    public Pokemon withDrawBox(int trainerId, int pokemonID){
        PcBox box =accountBill.get(trainerId).getBox();
        Pokemon pokemonOut= null;
        if (box.pokemonFoundedInsideBox(pokemonID)){
            pokemonOut = box.retrievePokemon(pokemonID);
            System.out.println("The pokemon was withdraw successfully");
        }else {
            System.out.println("The pokemon was not founded");
        }
        return pokemonOut;
    }
    public void switchBox(int trainerId){
        accountBill.get(trainerId).switchBoxes();
        System.out.println("Default box was Switch");
    }

    private boolean isRegistered(int trainerId){
       return accountBill.containsKey(trainerId);
    }





}
