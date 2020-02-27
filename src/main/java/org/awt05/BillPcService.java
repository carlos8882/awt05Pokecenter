package org.awt05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BillPcService {

    private List<PcBox> storageBox;
    private HashMap<Trainer , PcBox> boxes;

    public BillPcService(){
        storageBox = new LinkedList<>();
        boxes = new HashMap<>();
    }

    //public List<PcBox> getBox(Trainer trainer){

        //return boxes.getOrDefault(trainer, storageBox);
    //}
}
