package com.api.pokemon.restful.entities;

import javax.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @Column(name = "species_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;

    @OneToOne(mappedBy = "species",fetch = FetchType.LAZY)
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
