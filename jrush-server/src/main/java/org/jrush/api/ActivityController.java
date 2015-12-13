package org.jrush.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.jrush.domain.Activity;
import org.jrush.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Seb on 28/11/2015.
 */
@RestController
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(path = "activity/{candidateFirstName}", produces = "text/csv")
    public String getCandidateActivity(@PathVariable String candidateFirstName) throws JsonProcessingException {
        List<Activity> activities = activityRepository.findByExerciceCandidateLastName(candidateFirstName);
        return toCSV(activities);
    }

    public String toCSV (List<Activity> activities) throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Activity.class).withHeader();
        return mapper.writer(schema).writeValueAsString(activities);
    }
}
