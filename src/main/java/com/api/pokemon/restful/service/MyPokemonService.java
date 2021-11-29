package com.api.pokemon.restful.service;

import com.api.pokemon.restful.dao.MyPokemonDao;
import com.api.pokemon.restful.entities.MyPokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPokemonService {
    @Autowired
    MyPokemonDao dao;

    public void postPokemon(MyPokemon pokemon){
        dao.save(pokemon);
    }
    public void modifyPokemon(MyPokemon p){
        dao.save(p);
    }
    public void deletePokemon(int id){
        MyPokemon p = findMyPokemon(id);
        dao.delete(p);
    }
    public MyPokemon findMyPokemon(int id){
        return dao.findById(id).get();
    }
}
