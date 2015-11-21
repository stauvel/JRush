package org.jrush.exercice.cards;

import org.jrush.domain.Exercice;
import org.jrush.exercice.Data;
import org.jrush.spi.ExerciceCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Seb on 19/11/2015.
 */
public class CardCommand implements ExerciceCommand {

    private static List<Card> deck;
    static {
        deck = new ArrayList<>(52);
        for (Card.Category category : Card.Category.values()) {
            for (Card.Value value : Card.Value.values()) {
                deck.add(new Card(category, value));
            }
        }
    }

    @Override
    public Data init(Exercice exercice) {
        CardsData data = new CardsData();
        data.setCategoryOrder(Arrays.asList(Card.Category.values()));
        data.setValueOrder(Arrays.asList(Card.Value.values()));
        List<Card> shufleDeck = new ArrayList<>(deck);
        Collections.shuffle(shufleDeck);
        data.setCards(shufleDeck.subList(0, 10));
        return data;
    }

    @Override
    public CardsData solve(Exercice exercice) {
        CardsData data = new CardsData();
        CardsData exerciceData = (CardsData) exercice.getData();
        List<Card> orderedCards = new ArrayList<>(exerciceData.getCards());
        Collections.sort(orderedCards);
        data.setCards(orderedCards);
        return data;
    }

    @Override
    public Class<? extends Data> getAnswerType() {
        return CardsData.class;
    }
}
