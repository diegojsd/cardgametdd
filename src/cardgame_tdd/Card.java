/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame_tdd;

/**
 *
 * @author Aluno
 */
public class Card {
    private Suit suit;
    private Rank value;

    public Card(Suit suit, Rank value) {
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank() {
        return value;
    }

    public int getValue() {
        return value.getValue();
    }
}