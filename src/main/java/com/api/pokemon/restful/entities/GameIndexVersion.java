package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game_index_version")
public class GameIndexVersion {
    @Id
    @Column(name = "game_index_version_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    @OneToMany(mappedBy = "gameIndexVersion",fetch = FetchType.LAZY)
    private List<GameIndex> gameIndexList;

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

    public List<GameIndex> getGameIndexList() {
        return gameIndexList;
    }

    public void setGameIndexList(List<GameIndex> gameIndexList) {
        this.gameIndexList = gameIndexList;
    }
}
