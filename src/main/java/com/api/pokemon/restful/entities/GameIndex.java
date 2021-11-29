package com.api.pokemon.restful.entities;

import javax.persistence.*;

@Entity
@Table(name = "game_index")
public class GameIndex {
    @Id
    @Column(name = "game_index_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int gameIndex;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_index_version_id")
    private GameIndexVersion gameIndexVersion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private MyPokemon pokemon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public GameIndexVersion getGameIndexVersion() {
        return gameIndexVersion;
    }

    public void setGameIndexVersion(GameIndexVersion gameIndexVersion) {
        this.gameIndexVersion = gameIndexVersion;
    }

    public MyPokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(MyPokemon pokemon) {
        this.pokemon = pokemon;
    }
}
