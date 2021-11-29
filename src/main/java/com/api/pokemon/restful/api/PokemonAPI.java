package com.api.pokemon.restful.api;

import com.api.pokemon.restful.entities.MyPokemon;
import com.api.pokemon.restful.service.MyPokemonService;
import com.api.pokemon.restful.service.PokemonAPIService;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonAPI {
  @Autowired
  PokemonAPIService pokeService;
  @Autowired
  MyPokemonService myPokemonService;
  @GetMapping
  public Pokemon findPokemon(@RequestParam("id") int id) {
    return pokeService.getPokemon(id);
  }
  @GetMapping("/experience")
  public List<Pokemon>getPokemonMoreBaseExperience( @RequestParam("offset") int offset,@RequestParam("limit") int limit){
    return pokeService.getPokemonMoreBaseExperience(offset, limit);
  }

  @GetMapping("/heaviest")
  public List<Pokemon> getHeaviestPokemons( @RequestParam("offset") int offset,@RequestParam("limit") int limit){
      return pokeService.getHeaviestPokemon(offset, limit);
  }
  @GetMapping("/start/{name}")
  public List<Pokemon> getPokemonByNameStart(@PathVariable String name, @RequestParam("offset") int offset,@RequestParam("limit") int limit){
    return pokeService.getPokemonByNameStart(offset-1,limit,name);
  }
  //Post pokemon in my local database
  @PostMapping
  public void postMyPokemon(MyPokemon p){
    myPokemonService.postPokemon(p);
  }
  //Update pokmon in my local database
  @PutMapping
  public void updateMyPokemon(MyPokemon p){
    myPokemonService.postPokemon(p);
  }
  //delete a pokemon from my local database
  @DeleteMapping
  public void deleteMyPokemon(@RequestParam("id") int id){
    myPokemonService.deletePokemon(id);
  }

}
