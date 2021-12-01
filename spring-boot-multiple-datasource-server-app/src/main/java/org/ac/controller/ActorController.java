package org.ac.controller;

import org.ac.entities.Actor;
import org.ac.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ActorController {

    @Autowired
    private ActorServiceImpl actorService;

    @GetMapping(value = "/hi/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greetPerson(@PathVariable(name = "name") String personName) {
        return "hello and hi there!!!... " + personName;
    }

    @GetMapping(value = "/actors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Actor> allActorList() {
        return actorService.getAllActors();
    }

    @GetMapping(value = "/actors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Actor getActorById(@PathVariable(name = "id") int id) {
        return actorService.getActorById(id);
    }

    @DeleteMapping(value = "/actors/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer removeActor(@PathVariable(name = "id") int id) {
        return actorService.deleteActor(id);
    }

    @PostMapping(value = "/actors/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> saveNewActor(@RequestBody Actor actor) {
        return ResponseEntity.ok(actorService.addActor(actor));
    }

    @PutMapping(value = "/actors/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Actor> updateActor(@PathVariable(name = "id") Integer id, @RequestBody Actor actor) {
        return ResponseEntity.ok(actorService.updateActorDetails(id, actor));
    }


}

