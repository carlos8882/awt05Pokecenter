package org.awt05.trainer;

import java.util.UUID;

public class Trainer {

    private String name;
    private Backpack bag;
    private String trainerId;

    public Trainer(String name) {
        this.name = name;
        this.bag = new Backpack();
        this.trainerId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public Backpack getBag() {
        return bag;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setBag(Backpack bag) {
        this.bag = bag;
    }


    @Override
    public String toString() {
        return this.getName() + " " + this.getTrainerId().substring(0,3);
    }

}
