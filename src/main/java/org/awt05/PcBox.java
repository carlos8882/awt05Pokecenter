package org.awt05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PcBox {

    Map<Trainer, List<Pokemon>> storagebox;

    public PcBox() {
        this.storagebox = new HashMap<>();
    }


    //public List<Pokemon> getPokemon(Trainer trainer){
    //   return storagebox.getOrDefault(trainer, );
    //}
}
