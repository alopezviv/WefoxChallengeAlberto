package com.api.pokemon.restful.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="move_and_details")
public class MoveAndDetails {
    @Id
    @Column(name = "move_and_details_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "move_id")
    private Move move;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poke_moves_id")
    private PokeMove pokeMove;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "move_version_details_id")
    private MoveVersionDetail versionDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public PokeMove getPokeMove() {
        return pokeMove;
    }

    public void setPokeMove(PokeMove pokeMove) {
        this.pokeMove = pokeMove;
    }

    public MoveVersionDetail getVersionDetail() {
        return versionDetail;
    }

    public void setVersionDetail(MoveVersionDetail versionDetail) {
        this.versionDetail = versionDetail;
    }
}
