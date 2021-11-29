package com.api.pokemon.restful.entities;



import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "my_pokemon")
public class MyPokemon {

    @Id
    @Column(name = "pokemon_id")
    private int id;
    private String name;
    private int baseExperience;
    private int heigth;
    private boolean isDefault;
    @Column(name = "pokemon_order")
    private int order;
    private int weigth;
    private String locationAreaEncounters;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pokemon_ability",
            joinColumns = @JoinColumn(name="pokemon_id"),
            inverseJoinColumns = @JoinColumn(name="my_pokemon_ability_id")
    )
    private List<MyPokemonAbility> abilities;
    @OneToMany(mappedBy = "pokemon",fetch = FetchType.LAZY)
    private List<Form> forms;
    @OneToMany(mappedBy = "pokemon", fetch = FetchType.LAZY)
    private List<GameIndex> gameIndices;
    @ManyToMany
    @JoinTable(
            name = "pokemon_moves",
            joinColumns = @JoinColumn(name="pokemon_id"),
            inverseJoinColumns = @JoinColumn(name="move_id")
    )
    private List<Move> moves;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id", referencedColumnName = "species_id")
    private Species species;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprites_id", referencedColumnName = "sprites_id")
    private Sprites sprites;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pokemon_stats",
            joinColumns = @JoinColumn(name="pokemon_id"),
            inverseJoinColumns = @JoinColumn(name="stat_id")
    )
    private List<Stat> stats;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pokemon_pokeType",
            joinColumns = @JoinColumn(name="pokemon_id"),
            inverseJoinColumns = @JoinColumn(name="pokemon_type_id")
    )
    private List<PokemonType> pokeTypes;

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

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public List<MyPokemonAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<MyPokemonAbility> abilities) {
        this.abilities = abilities;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<PokemonType> getTypes() {
        return pokeTypes;
    }

    public void setTypes(List<PokemonType> types) {
        this.pokeTypes = types;
    }
}
