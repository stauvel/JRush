package org.jrush.api;

import org.jrush.domain.Candidate;
import org.jrush.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Seb on 18/11/2015.
 */
@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/candidate/{firstName}/{lastName}")
    public Candidate createCandidate(@PathVariable("firstName")String firstName, @PathVariable("lastName")String lastName) {
        Candidate candidate = new Candidate(firstName, lastName);
        candidate = candidateRepository.save(candidate);
        return candidate;
    }

}
