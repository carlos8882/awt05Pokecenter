package org.awt05.billPc;
/**
 * @author: Carlos Meneses Covarrubias
 * @date: 03/02/2020
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.List;


public class BoxList {

    private List<PcBox> boxes;
    private int defaultBox;

    public BoxList() {
        boxes = new ArrayList<>(2);
        boxes.add(new PcBox());
        boxes.add(new PcBox());
        defaultBox = 0;
    }

    public PcBox getBox() {
        if (defaultBox == 0) {
            System.out.println("Current Box: Box 1");
        } else {
            System.out.println("Current Box: Box 2");
        }
        return boxes.get(defaultBox);
    }

    public void switchBoxes() {
        if (defaultBox == 0) {
            defaultBox = 1;
        } else {
            defaultBox = 0;
        }
    }


}
