package org.jrush.example;

/**
 * Created by Seb on 18/11/2015.
 */
public class Card implements Comparable<Card> {


    public static enum Category{DIAMOND,HEART,SPADE,CLUB}
    public static enum Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    private Category category;
    private Value value;

    public Card() {
    }

    public Card(Category category, Value value) {
        this.category = category;
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (category != card.category) return false;
        if (value != card.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }


    @Override
    public int compareTo(Card o) {
        int categoryComp = this.category.ordinal() - o.category.ordinal();
        int valueComp = this.value.ordinal() - o.value.ordinal();
        return categoryComp * 13 + valueComp;
    }

}
