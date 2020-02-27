package org.awt05;

public class Trainer {

    private String name;
    private Backpack bag;

    public Trainer(String name, Backpack bag) {
        this.name = name;
        this.bag = bag;
    }

    public String getName() {
        return name;
    }

    public Backpack getBag() {
        return bag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBag(Backpack bag) {
        this.bag = bag;
    }

    public boolean hasPokemon(){
        if (this.bag
                .getTeam()
                .size() == 0){
            return false;
        }
        return true;
    }

    public void addPokemon(Pokemon pokemon){
        this.bag
            .addPokemon(pokemon);
    }
}
