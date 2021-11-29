package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemon_type")
public class PokemonType {
    @Id
    @Column(name = "pokemon_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int slot;
    @ManyToMany(mappedBy = "pokeTypes",fetch = FetchType.LAZY)
    private List<MyPokemon> pokemons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Type types;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return types;
    }

    public void setType(Type type) {
        this.types = type;
    }
}
