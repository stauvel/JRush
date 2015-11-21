package org.jrush.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jrush.domain.Candidate;
import org.jrush.domain.Exercice;
import org.jrush.exercice.Data;
import org.jrush.exercice.cards.CardCommand;
import org.jrush.repository.CandidateRepository;
import org.jrush.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Seb on 18/11/2015.
 */
@RestController
public class ExerciceController {

    @Autowired
    private ExerciceRepository exerciceRepository;
    @Autowired
    private CandidateRepository candidateRepository;

    @RequestMapping("/test/cards/{uuid}")
    public ResponseEntity<Exercice> initCardsExercice(@PathVariable String uuid) {
        Candidate candidate = candidateRepository.findOne(uuid);
        if(candidate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Exercice exercice = new Exercice();
        exercice.setDateCreation(new Date());
        exercice.setCandidate(candidate);
        CardCommand exerciceCommand = new CardCommand();
        exercice.setData(exerciceCommand.init(exercice));
        exerciceRepository.save(exercice);
        return new ResponseEntity<>(exercice, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/test/{uuid}")
    public ResponseEntity<Data> tryCardsExercice(@RequestBody String data, @PathVariable String uuid) throws IOException {
        Exercice exercice = exerciceRepository.findOne(uuid);
        if(data == null || exercice == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CardCommand exerciceCommand = new CardCommand();
        Data solution = exerciceCommand.solve(exercice);

        Data value = new ObjectMapper().readValue(data, exerciceCommand.getAnswerType());
        if(solution.match(value)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(solution, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping("/test/solution/{uuid}")
    public ResponseEntity<Data> solveCardsExercice(@PathVariable String uuid){
        Exercice exercice = exerciceRepository.findOne(uuid);
        if(exercice == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CardCommand exerciceCommand = new CardCommand();
        return new ResponseEntity<>(exerciceCommand.solve(exercice), HttpStatus.OK);
    }
}
