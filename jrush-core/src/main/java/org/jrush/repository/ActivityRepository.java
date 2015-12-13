package org.jrush.repository;

import org.jrush.domain.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Seb on 23/11/2015.
 */
@RepositoryRestResource
public interface ActivityRepository extends MongoRepository<Activity, String> {

    List<Activity> findByExerciceCandidateLastName(@Param("name") String name);
    List<Activity> findByExerciceCandidateFirstNameAndExerciceCandidateLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}

