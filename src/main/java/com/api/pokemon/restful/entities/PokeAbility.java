package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokeability")
public class PokeAbility {
    @Id
    @Column(name = "pokeability_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    @OneToMany(mappedBy = "ability",fetch = FetchType.LAZY)
    private List<MyPokemonAbility> myPokemonAbilities;

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

    public List<MyPokemonAbility> getMyPokemonAbilities() {
        return myPokemonAbilities;
    }

    public void setMyPokemonAbilities(List<MyPokemonAbility> myPokemonAbilities) {
        this.myPokemonAbilities = myPokemonAbilities;
    }
}
