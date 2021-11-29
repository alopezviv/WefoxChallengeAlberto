package com.api.pokemon.restful.dao;

import com.api.pokemon.restful.entities.MyPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyPokemonDao extends JpaRepository<MyPokemon,Integer> {
     Optional<MyPokemon> findById(int id);
}
