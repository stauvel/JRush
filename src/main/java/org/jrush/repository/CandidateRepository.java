package org.jrush.repository;

import org.jrush.domain.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Seb on 18/11/2015.
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface CandidateRepository  extends MongoRepository<Candidate, String> {

    List<Candidate> findByLastName(@Param("name") String name);

}
