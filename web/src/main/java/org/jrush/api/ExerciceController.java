package org.jrush.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jrush.domain.Activity;
import org.jrush.domain.Candidate;
import org.jrush.domain.Exercice;
import org.jrush.exercice.Data;
import org.jrush.repository.ActvityRepository;
import org.jrush.repository.CandidateRepository;
import org.jrush.repository.ExerciceRepository;
import org.jrush.spi.ExerciceCommand;
import org.jrush.spi.ExerciceServiceLoader;
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
    @Autowired
    private ActvityRepository actvityRepository;
    @Autowired
    private ExerciceServiceLoader exerciceServiceLoader;

    @RequestMapping("/test/cards/{uuid}")
    public ResponseEntity<Exercice> initCardsExercice(@PathVariable String uuid) {
        Candidate candidate = candidateRepository.findOne(uuid);
        if(candidate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Exercice exercice = new Exercice();
        exercice.setDateCreation(new Date());
        exercice.setCandidate(candidate);
        exercice.setName("cards");
        ExerciceCommand exerciceCommand = exerciceServiceLoader.getExercice(exercice.getName());
        exercice.setData(exerciceCommand.init(exercice));
        exerciceRepository.save(exercice);
        saveActivity(exercice, Activity.Type.READ_PREDICATE);
        return new ResponseEntity<>(exercice, HttpStatus.OK);
    }

    private void saveActivity(Exercice exercice, Activity.Type type) {
        actvityRepository.save(new Activity(exercice, type));
    }

    @RequestMapping(method = RequestMethod.POST,path = "/test/{uuid}")
    public ResponseEntity<Data> tryExercice(@RequestBody String data, @PathVariable String uuid) throws IOException {
        Exercice exercice = exerciceRepository.findOne(uuid);
        if(data == null || exercice == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ExerciceCommand exerciceCommand = exerciceServiceLoader.getExercice(exercice.getName());
        Data solution = exerciceCommand.solve(exercice);

        Data value = new ObjectMapper().readValue(data, exerciceCommand.getAnswerType());
        if(solution.match(value)) {
            saveActivity(exercice, Activity.Type.SUBMIT_ANSWER_OK);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            saveActivity(exercice, Activity.Type.SUBMIT_ANSWER_BAD);
            return new ResponseEntity<>(solution, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping("/test/solution/{uuid}")
    public ResponseEntity<Data> solveCardsExercice(@PathVariable String uuid){
        Exercice exercice = exerciceRepository.findOne(uuid);
        saveActivity(exercice, Activity.Type.READ_ANSWER);
        if(exercice == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ExerciceCommand exerciceCommand = exerciceServiceLoader.getExercice(exercice.getName());
        return new ResponseEntity<>(exerciceCommand.solve(exercice), HttpStatus.OK);
    }
}
