package org.jrush.spi;

import org.jrush.domain.Exercice;
import org.jrush.exercice.Data;

/**
 * Created by Seb on 21/11/2015.
 */
public interface ExerciceCommand {

    /**
     * The unique name of the exercice's command
     * @return
     */
    String getName();

    /**
     * Create the exercice data
     * @param exercice
     */
    Data init(Exercice exercice);

    /**
     * Compute the solution of the exercice
     * @param exercice
     * @return
     */
    Data solve(Exercice exercice);

    /**
     * Specify the type of your answer's data
     */
    Class<? extends Data> getAnswerType();

}
