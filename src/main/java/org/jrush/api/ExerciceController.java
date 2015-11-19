package org.jrush.api;

import org.jrush.domain.Candidate;
import org.jrush.domain.Exercice;
import org.jrush.exercice.Data;
import org.jrush.exercice.cards.CardExercice;
import org.jrush.exercice.cards.CardsData;
import org.jrush.repository.CandidateRepository;
import org.jrush.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Exercice cardExercice = new CardExercice();
        cardExercice.setDateCreation(new Date());
        cardExercice.setCandidate(candidate);
        cardExercice.init();
        exerciceRepository.save(cardExercice);
        return new ResponseEntity<>(cardExercice, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/test/{uuid}")
    public ResponseEntity<Data> tryCardsExercice(@RequestBody CardsData data, @PathVariable String uuid) {
        Exercice exercice = exerciceRepository.findOne(uuid);
        if(data == null || exercice == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Data solution = exercice.solve();
        if(solution.match(data)) {
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
        return new ResponseEntity<>(exercice.solve(), HttpStatus.OK);
    }
}
