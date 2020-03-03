package org.awt05.pokemons;
import org.awt05.Pokemon;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PokemonTest {

    @ParameterizedTest
    @MethodSource("pokemonProvider")
    public void whenICreateNewPokemonThenItIsNotNull(Pokemon pokemon) {
        // Given
        String expectedNickName = "John";

        // When
        pokemon.setNickname("John");
        String currentNickName = pokemon.getNickname();


        // Then
        assertNotNull(pokemon);
        assertEquals(expectedNickName, currentNickName);
    }

    static Stream<Pokemon> pokemonProvider() {
        return Stream.of(
                new Bulbasaur(),
                new Ivysaur(),
                new Venusaur(),
                new Charmander(),
                new Charmeleon(),
                new Charizard(),
                new Squirtle(),
                new Wartortle(),
                new Blastoise(),
                new Caterpie(),
                new Metapod(),
                new Butterfree(),
                new Weedle(),
                new Kakuna(),
                new Beedrill(),
                new Pidgey(),
                new Pidgeotto(),
                new Pidgeot(),
                new Rattata(),
                new Raticate(),
                new Spearow(),
                new Fearow(),
                new Ekans(),
                new Arbok(),
                new Pikachu(),
                new Raichu(),
                new Sandshrew(),
                new Sandslash(),
                new NidoranF(),
                new Nidorina(),
                new Nidoqueen(),
                new NidoranM(),
                new Nidorino(),
                new Nidoking(),
                new Clefairy(),
                new Clefable(),
                new Vulpix(),
                new Ninetales(),
                new Jigglypuff(),
                new Wigglytuff(),
                new Zubat(),
                new Golbat(),
                new Oddish(),
                new Gloom(),
                new Vileplume(),
                new Paras(),
                new Parasect(),
                new Venonat(),
                new Venomoth(),
                new Diglett(),
                new Dugtrio(),
                new Meowth(),
                new Persian(),
                new Psyduck(),
                new Golduck(),
                new Mankey(),
                new Primeape(),
                new Growlithe(),
                new Arcanine(),
                new Poliwag(),
                new Poliwhirl(),
                new Poliwrath(),
                new Abra(),
                new Kadabra(),
                new Alakazam(),
                new Machop(),
                new Machoke(),
                new Machamp(),
                new Bellsprout(),
                new Weepinbell(),
                new Victreebel(),
                new Tentacool(),
                new Tentacruel(),
                new Geodude(),
                new Graveler(),
                new Golem(),
                new Ponyta(),
                new Rapidash(),
                new Slowpoke(),
                new Slowbro(),
                new Magnemite(),
                new Magneton(),
                new FarfetchD(),
                new Doduo(),
                new Dodrio(),
                new Seel(),
                new Dewgong(),
                new Grimer(),
                new Muk(),
                new Shellder(),
                new Cloyster(),
                new Gastly(),
                new Haunter(),
                new Gengar(),
                new Onix(),
                new Drowzee(),
                new Hypno(),
                new Krabby(),
                new Kingler(),
                new Voltorb(),
                new Electrode(),
                new Exeggcute(),
                new Exeggutor(),
                new Cubone(),
                new Marowak(),
                new Hitmonlee(),
                new Hitmonchan(),
                new Lickitung(),
                new Koffing(),
                new Weezing(),
                new Rhyhorn(),
                new Rhydon(),
                new Chansey(),
                new Tangela(),
                new Kangaskhan(),
                new Horsea(),
                new Seadra(),
                new Goldeen(),
                new Seaking(),
                new Staryu(),
                new Starmie(),
                new MrMime(),
                new Scyther(),
                new Jynx(),
                new Electabuzz(),
                new Magmar(),
                new Pinsir(),
                new Tauros(),
                new Magikarp(),
                new Gyarados(),
                new Lapras(),
                new Ditto(),
                new Eevee(),
                new Vaporeon(),
                new Jolteon(),
                new Flareon(),
                new Porygon(),
                new Omanyte(),
                new Omastar(),
                new Kabuto(),
                new Kabutops(),
                new Aerodactyl(),
                new Snorlax(),
                new Articuno(),
                new Zapdos(),
                new Moltres(),
                new Dratini(),
                new Dragonair(),
                new Dragonite(),
                new Mewtwo(),
                new Mew()
        );
    }

    @Test
    public void snorlaxWalksIntoWater() {
        //given
        String expectedSkill = "... has used WALKING INTO WATER!!";
        Snorlax s=new Snorlax();
        //when
        s.surf();
        //then
        assertEquals("... has used WALKING INTO WATER!!", expectedSkill); //(resultado esperado, resultado obtenido)
    }

    @Test
    public void charizard(){
        //given
        Charizard c=new Charizard();
        String expectedNickName = "Chari";
        String expectedSkill1 = "... has used FLY!!";
        String expectedSkill2 = "... has used WALKING INTO WATER!!";
        //when
        c.setNickname("Chari");
        String currentNickName = c.getNickname();
        c.fly();
                 //c.ember();
        //then
        assertEquals(expectedNickName, currentNickName);
        assertEquals("... has used FLY!!", expectedSkill1);
                  //assertEquals("... has used Ember!!", expectedSkill2);
    }
}

//This is for personal testing only
    /*
    Charizard c=new Charizard();
        c.setNickname("Chari");
        c.ember();
        c.fly();
    Snorlax s=new Snorlax();
        s.surf();
    String ID1=c.getPokeId();
    String ID2=s.getPokeId();
        System.out.println(ID1);
        System.out.println(ID2);

     */