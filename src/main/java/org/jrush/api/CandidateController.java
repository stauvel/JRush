package org.jrush.api;

import org.jrush.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Seb on 18/11/2015.
 */
@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;


}
