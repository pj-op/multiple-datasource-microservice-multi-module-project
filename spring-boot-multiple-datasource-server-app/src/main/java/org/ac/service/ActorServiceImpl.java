package org.ac.service;

import org.ac.entities.Actor;
import org.ac.exception.NoRecordsFoundException;
import org.ac.repositories.mysql.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    private ActorRepository actorRepository;

    // Retrieve all the actor records
    @Override
    @Transactional(readOnly = true)
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    // Getting actor based on id
    @Override
    @Transactional(readOnly = true)
    public Actor getActorById(int id) {
        if (actorRepository.existsById(id)) {
            return actorRepository.findByActorId(id);
        } else {
            throw new NoRecordsFoundException("Record with id " + id + " not found..");
        }
    }

    // Adding new actor
    @Override
    @Transactional(readOnly = true)
    public Actor addActor(Actor actor) {
        return actorRepository.save(actor);
    }

    // Removing actor record based on id
    @Override
    @Transactional(readOnly = false)
    public Integer deleteActor(Integer id) {
        if (id != null && actorRepository.existsById(id)) {
            return actorRepository.deleteByActorId(id);
        } else {
            throw new NoRecordsFoundException("No record exist");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public Actor updateActorDetails(Integer id, Actor actor) {
        if (id != null && actorRepository.existsById(id) && actor != null) {

            Actor actor1 = new Actor();
            actor1.setLastUpdate(actor.getLastUpdate());
            actor1.setActorId(actor.getActorId());
            actor1.setFirstName(actor.getFirstName());
            actor1.setLastName(actor.getLastName());

            return actorRepository.save(actor1);
        } else {
            throw new NoRecordsFoundException("Records with Id " + id + " does not exist");
        }

    }


}
