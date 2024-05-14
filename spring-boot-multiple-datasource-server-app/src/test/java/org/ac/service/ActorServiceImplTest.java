package org.ac.service;

import org.ac.entities.Actor;
import org.ac.repositories.mysql.ActorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActorServiceImplTest {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorServiceImpl actorService;

    @Test
    @DisplayName("Should returns all actors")
    void getAllActorsReturnsAllActors() {
        Actor actor1 = new Actor(1, "firstName1", "lastName1", new Date());
        Actor actor2 = new Actor(2, "firstName2", "lastName2", new Date());
        List<Actor> actors = Arrays.asList(actor1, actor2);

        when(actorRepository.findAll()).thenReturn(actors);

        List<Actor> result = actorService.getAllActors();

        assertEquals(actors, result);
    }
}