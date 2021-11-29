package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "move_version_details")
public class MoveVersionDetail {
    @Id
    @Column(name = "move_version_details_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String levelLearned;
    private String learnMethodName;
    private String learnMethodUrl;
    private String versionName;
    private String versionUrl;

    @OneToMany(mappedBy = "versionDetail",fetch = FetchType.LAZY)
    private List<MoveAndDetails> moveAndDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelLearned() {
        return levelLearned;
    }

    public void setLevelLearned(String levelLearned) {
        this.levelLearned = levelLearned;
    }

    public String getLearnMethodName() {
        return learnMethodName;
    }

    public void setLearnMethodName(String learnMethodName) {
        this.learnMethodName = learnMethodName;
    }

    public String getLearnMethodUrl() {
        return learnMethodUrl;
    }

    public void setLearnMethodUrl(String learnMethodUrl) {
        this.learnMethodUrl = learnMethodUrl;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionUrl() {
        return versionUrl;
    }

    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl;
    }

    public List<MoveAndDetails> getMoveAndDetails() {
        return moveAndDetails;
    }

    public void setMoveAndDetails(List<MoveAndDetails> moveAndDetails) {
        this.moveAndDetails = moveAndDetails;
    }
}
