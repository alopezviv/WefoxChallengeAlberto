package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "stat_type")
public class StatType {
    @Id
    @Column(name = "stat_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    @OneToMany(mappedBy = "statType",fetch = FetchType.LAZY)
    private List<Stat> stats;

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

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}
