package com.api.pokemon.restful.helper;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonAPIHelper {

    PokeApi pokeApi = new PokeApiClient();

    public List<Pokemon> getPokemonList(int offset, int limit){
        List<Pokemon> resultList = new ArrayList<>();
        for(int i = offset; i < offset+limit; i++ ){
            resultList.add(getPokemon(i));
        }

        return resultList;
    }
    public  NamedApiResourceList getPokemonNames(int offset, int limit){
        return pokeApi.getPokemonList(offset, limit);
    }
    public Pokemon getPokemon(int id){
        return pokeApi.getPokemon(id);
    }

}
