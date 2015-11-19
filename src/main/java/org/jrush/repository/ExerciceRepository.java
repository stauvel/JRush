package org.jrush.repository;

import org.jrush.domain.Exercice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Seb on 19/11/2015.
 */
@RepositoryRestResource
public interface ExerciceRepository  extends MongoRepository<Exercice, String> {
}
