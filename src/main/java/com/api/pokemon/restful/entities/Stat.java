package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stats")
public class Stat {
    @Id
    @Column(name="stat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int baseStat;
    private int effort;
    @ManyToMany(mappedBy = "stats",fetch = FetchType.LAZY)
    private List<MyPokemon> pokemons;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stat_type_id")
    private StatType statType;

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

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public StatType getStatType() {
        return statType;
    }

    public void setStatType(StatType statType) {
        this.statType = statType;
    }
}
