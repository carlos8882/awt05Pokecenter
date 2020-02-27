package org.awt05;

import java.util.List;

public class Backpack {
    private List<Pokemon> team;

    public Backpack(List<Pokemon> team){
        this.team = team;
    }

    public void addPokemon(Pokemon pokemon){
        this.team
            .add(pokemon);
    }

    public void retrievePokemon(Pokemon pokemon){
        this.team
            .add(pokemon);
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }
}
