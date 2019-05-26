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
public class Dealer {
    private Deck deck;

    public Dealer(){
        this.deck = new Deck();
        deck.addCards();
        deck.shuffle();
    }

    public int countUnshuffledCards() {
        return deck.countUnshuffledCards();
    }

    public int countCards() {
        return deck.countCards();
    }


    public void dealCard(Player player) {
        Card card = deck.dealCard();
        player.takeCard(card);

    }
}