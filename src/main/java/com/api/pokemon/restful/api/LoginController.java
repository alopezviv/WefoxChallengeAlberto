package com.api.pokemon.restful.api;

import com.api.pokemon.restful.security.TokenCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pokemon")
public class LoginController {
    @Autowired
    TokenCreator tokenCreator;

    @PostMapping("/login")
    public String login(@RequestParam("name") String name){
        return tokenCreator.generateToken(name);
    }
}
