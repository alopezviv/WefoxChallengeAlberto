package com.api.pokemon.restful.entities;

import javax.persistence.*;

@Entity
@Table(name = "sprites")
public class Sprites {
    @Id
    @Column(name = "sprites_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String backDefault;
    private String backFemale;
    private String backShiny;
    private String backShunyFemale;
    private String frontDefault;
    private String frontFemale;
    private String frontShiny;
    private String frontShinyFemale;

    @OneToOne(mappedBy = "sprites",fetch = FetchType.LAZY)
    private MyPokemon pokemon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getBackFemale() {
        return backFemale;
    }

    public void setBackFemale(String backFemale) {
        this.backFemale = backFemale;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public String getBackShunyFemale() {
        return backShunyFemale;
    }

    public void setBackShunyFemale(String backShunyFemale) {
        this.backShunyFemale = backShunyFemale;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public void setFrontShinyFemale(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    public MyPokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(MyPokemon pokemon) {
        this.pokemon = pokemon;
    }
}
