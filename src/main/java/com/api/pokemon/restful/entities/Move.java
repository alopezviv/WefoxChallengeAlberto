package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "moves")
public class Move {
    @Id
    @Column(name = "move_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "move_order")
    private int order;
    @ManyToMany(mappedBy = "moves",fetch = FetchType.LAZY)
    private List<MyPokemon> pokemons;
    @OneToMany(mappedBy = "move",fetch = FetchType.LAZY)
    private List<MoveAndDetails> moveAndDetails;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<MoveAndDetails> getMoveAndDetails() {
        return moveAndDetails;
    }

    public void setMoveAndDetails(List<MoveAndDetails> moveAndDetails) {
        this.moveAndDetails = moveAndDetails;
    }
}
