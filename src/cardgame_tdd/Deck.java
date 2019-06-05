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
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;
    private ArrayList<Card> shuffledCards;

    public Deck(){
        this.cards = new ArrayList<>();
        this.shuffledCards = new ArrayList<>();
    }


    public int countUnshuffledCards() {
        return cards.size();
    }

    public void addCards() {
        for (Suit suit : Suit.values()){
            for (Rank value : Rank.values()){
                Card card = new Card(suit,value);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        shuffledCards.clear();
        for (int i = cards.size(); i > 0; i--){
            double randomNumber = Math.random();
            randomNumber = randomNumber * i;
            int randomIndex = (int) randomNumber;
            Card randomCard = cards.remove(randomIndex);
            shuffledCards.add(randomCard);
        }
        addCards();
    }

    public int countCards() {
        return shuffledCards.size();
    }

    public Card dealCard() {
       Card dealtCard = shuffledCards.remove(0);
       return dealtCard;
    }
}