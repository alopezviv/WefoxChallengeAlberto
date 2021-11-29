package com.api.pokemon.restful.service;

import com.api.pokemon.restful.helper.PokemonAPIHelper;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PokemonAPIService {

    @Autowired
    private PokemonAPIHelper pokeHelper;


    //Returns the 3 heaviest pokemon serching starting in the offset, and limiting the search tu a number. if the limit is 3 or less return all the pokemons
    public List<Pokemon> getHeaviestPokemon(int offset, int limit){
        List<Pokemon> rawPokeList = pokeHelper.getPokemonList(offset, limit);
        Collections.sort(rawPokeList, (a,b) ->Integer.compare(b.getWeight(),a.getWeight()));
        if(limit <=3){
            return rawPokeList;
        }
        List<Pokemon> resultList = rawPokeList.subList(0,3);
        return resultList;
    }
    //Returns the 3 pokemon with more base experience starting in the offset, and limiting the search tu a number. if the limit is 3 or less return all the pokemons
    public List<Pokemon> getPokemonMoreBaseExperience(int offset, int limit){
        List<Pokemon> rawPokeList = pokeHelper.getPokemonList(offset, limit);
        Collections.sort(rawPokeList, (a,b) ->Integer.compare(b.getBaseExperience(),a.getBaseExperience()));
        if(limit <=3){
            return rawPokeList;
        }
        List<Pokemon> resultList = rawPokeList.subList(0,3);
        return resultList;
    }

    //Takes 2 int, the first one is where the serch start and the second it's the number of pokemons serched.
    //Takes a String and return a list of Pokemon which their names starts with that string.
    public List<Pokemon> getPokemonByNameStart(int offset, int limit, String name ){
        List<Pokemon> result= new ArrayList<>();
        NamedApiResourceList pokeList = pokeHelper.getPokemonNames(offset, limit);
        for(NamedApiResource pokemonName: pokeList.getResults()){
            if(pokemonName.getName().startsWith(name)){
                Pokemon pokemon = pokeHelper.getPokemon(pokemonName.getId());
                result.add(pokemon);
            }
        }

        return result;
    }
    //return a pokemon by id
    public Pokemon getPokemon(int id){
        return pokeHelper.getPokemon(id);
    }
}
