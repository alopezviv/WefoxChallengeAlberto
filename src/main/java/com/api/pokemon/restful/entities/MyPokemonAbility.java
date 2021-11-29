package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "my_pokemon_ability")
public class MyPokemonAbility {
    @Id
    @Column(name = "my_pokemon_ability_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isHidden;
    private int slot;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pokeability_id")
    private PokeAbility ability;
    @ManyToMany(mappedBy = "abilities",fetch = FetchType.LAZY)
    List<MyPokemon> pokemons;

    public List<MyPokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<MyPokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public PokeAbility getAbility() {
        return ability;
    }

    public void setAbility(PokeAbility ability) {
        this.ability = ability;
    }
}
