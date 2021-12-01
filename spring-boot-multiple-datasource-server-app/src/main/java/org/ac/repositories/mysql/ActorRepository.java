package org.ac.repositories.mysql;

import org.ac.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Modifying
    @Transactional(readOnly = false)
    @Query(value = "DELETE FROM actor_copy a WHERE a.actor_id=:actorId",nativeQuery = true)
    Integer deleteByActorId(@Param("actorId") Integer id);

    Actor findByActorId(Integer actorId);

}
