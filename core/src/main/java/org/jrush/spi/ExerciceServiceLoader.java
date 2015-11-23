package org.jrush.spi;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Seb on 22/11/2015.
 */
public class ExerciceServiceLoader {

    private ServiceLoader<ExerciceCommand> commandLoader;
    private Map<String, ExerciceCommand> commands;

    public ExerciceServiceLoader () {
        // Discover and register the available exercices
        commands = new ConcurrentHashMap<>();
        commandLoader = ServiceLoader.load(ExerciceCommand.class);
        Iterator<ExerciceCommand> commandsIterator = commandLoader.iterator();
        while (commandsIterator.hasNext())
        {
            ExerciceCommand exerciceCommand = commandsIterator.next();
            commands.put(exerciceCommand.getName(), exerciceCommand);
        }
    }

    public ExerciceCommand getExercice(String exerciceName) {
        return commands.get(exerciceName);
    }
}
