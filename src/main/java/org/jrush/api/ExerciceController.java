package org.jrush.api;

import org.jrush.domain.Exercice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Seb on 18/11/2015.
 */
@RestController
public class ExerciceController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Exercice greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Exercice("cards", "ok");
    }
}
