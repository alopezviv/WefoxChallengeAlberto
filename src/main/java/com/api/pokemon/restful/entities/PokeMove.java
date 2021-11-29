package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pokemon_move")
public class PokeMove {
    @Id
    @Column(name = "pokemove_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;

    @OneToMany(mappedBy = "pokeMove",fetch = FetchType.LAZY)
    private List<MoveAndDetails> moveAndDetails;

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

    public List<MoveAndDetails> getMoveAndDetails() {
        return moveAndDetails;
    }

    public void setMoveAndDetails(List<MoveAndDetails> moveAndDetails) {
        this.moveAndDetails = moveAndDetails;
    }
}
