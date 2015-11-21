package org.jrush.exercice.cards;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jrush.exercice.Data;

import java.util.Collection;

/**
 * Created by Seb on 18/11/2015.
 */
public class CardsData implements Data {

    private Collection<Card> cards;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<Card.Category> categoryOrder;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Collection<Card.Value> valueOrder;

    public Collection<Card> getCards() {
        return cards;
    }

    public void setCards(Collection<Card> cards) {
        this.cards = cards;
    }

    public Collection<Card.Category> getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Collection<Card.Category> categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public Collection<Card.Value> getValueOrder() {
        return valueOrder;
    }

    public void setValueOrder(Collection<Card.Value> valueOrder) {
        this.valueOrder = valueOrder;
    }

    @Override
    public boolean match(Data other) {
        return this.cards.equals(((CardsData) other).getCards());
    }
}
