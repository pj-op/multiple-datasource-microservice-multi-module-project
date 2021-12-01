package org.ac.service;

import org.ac.entities.Actor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IActorService {
    // Retrieve all the actor records
    List<Actor> getAllActors();

    // Getting actor based on id
    Actor getActorById(int id);

    // Adding new actor
    Actor addActor(Actor actor);

    // Removing actor record based on id
    Integer deleteActor(Integer id);

    // Updating Actor based on the id
    Actor updateActorDetails(Integer id, Actor actor);
}
