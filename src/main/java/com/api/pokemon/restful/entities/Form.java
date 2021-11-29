package com.api.pokemon.restful.entities;

import me.sargunvohra.lib.pokekotlin.model.Pokemon;

import javax.persistence.*;

@Entity
@Table(name="forms")
public class Form {
    @Id
    @Column(name = "form_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private MyPokemon pokemon;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MyPokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(MyPokemon pokemon) {
        this.pokemon = pokemon;
    }
}
