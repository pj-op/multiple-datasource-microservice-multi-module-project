package org.ac.service;

import org.ac.entities.Actor;
import org.ac.exception.NoRecordsFoundException;
import org.ac.repositories.mysql.ActorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ActorServiceImplTest {

    @InjectMocks
    ActorServiceImpl actorService;

    @Mock
    ActorRepository actorRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void getAllActors_test() {
        List<Actor> myList = new ArrayList<>();
        Actor actor1 = new Actor(1, "PJ", "OP", Date.valueOf(LocalDate.now()));
        Actor actor2 = new Actor(2, "PJ2", "OPQR", Date.valueOf(LocalDate.now()));

        myList.add(actor1);
        myList.add(actor2);

        when(actorRepository.findAll())
                .thenReturn(myList);

    }

    @Test
    public void getActorById_success() {
        Actor actor1 = new Actor(1, "PJ", "OP", Date.valueOf(LocalDate.now()));

        int actorId = 1;
        when(actorRepository.existsById(actorId))
                .thenReturn(true);
        when(actorRepository.findByActorId(actorId))
                .thenReturn(actor1);
        actorService.getActorById(actorId);
    }

    @Test(expected = NoRecordsFoundException.class)
    public void getActorById_withException() throws NoRecordsFoundException {
        int actorId = 1;
        when(actorRepository.existsById(actorId))
                .thenReturn(false);
        when(actorRepository.findByActorId(actorId))
                .thenThrow(new NoRecordsFoundException("Record with id " + actorId + " not found.."));
        actorService.getActorById(actorId);
    }

    @Test
    public void addActor() {
    }

    @Test
    public void deleteActor() {
    }

    @Test
    public void updateActorDetails() {
    }
}