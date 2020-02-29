package org.awt05;

import java.util.ArrayList;
import java.util.List;

public class BoxList {

    private List<PcBox> boxes;
    private int defaultBox;

    public BoxList(){
        boxes = new ArrayList<>();
        boxes.add(new PcBox());
        boxes.add(new PcBox());
        defaultBox = 0;
    }

    public PcBox getBox(){
        return boxes.get(defaultBox);
    }

    public void switchBoxes(){
        if (defaultBox == 0){
            defaultBox = 1;
        }else {
            defaultBox = 0;
        }
    }


}
