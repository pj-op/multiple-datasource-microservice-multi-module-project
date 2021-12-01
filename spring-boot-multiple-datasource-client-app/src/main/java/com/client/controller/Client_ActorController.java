package com.client.controller;

import com.client.dto.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/client-api")
public class Client_ActorController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping(value = "/actors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> findActorById(@PathVariable(name = "id") int id) {
        Actor actor = restTemplate.getForObject("http://MULTIPLE-DATASOURCE/api/actors/" + id, Actor.class);
        return ResponseEntity.ok(actor);
    }

    @GetMapping(value = "/actors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Actor[] allActors() {
        ResponseEntity<Actor[]> actorList = restTemplate.getForEntity("http://MULTIPLE-DATASOURCE/api/actors/", Actor[].class);
        Actor[] actors = actorList.getBody();
        return actors;
    }


}
