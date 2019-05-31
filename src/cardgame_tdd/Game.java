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

public class Game {
    private ArrayList<Player> players;
    private Dealer dealer;


    public Game(){
        this.players = new ArrayList<>();
        this.dealer = new Dealer();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int countPlayers() {
        return players.size();
    }

    public void dealGame() {
        for (Player player : players){
            dealer.dealCard(player);
        }
    }

    public String checkWinner() {
        ArrayList<Integer> cardValues = new ArrayList<>();
        for (Player player : players) {
            int cardValue = player.getHandValue();
            cardValues.add(cardValue);
        }
        return "Someone wins";
    }
    
    public Player jogar(Player p1, Player p2){
        int p1card = p1.getCardValue();
        int p2card = p2.getCardValue();
        if (p1card>p2card){
            p1.removeCard();
            p2.removeCard();
            return p1;         
        }else if(p1card<p2card){
            p1.removeCard();
            p2.removeCard();
            return p2;
            }else{
                p1.removeCard();
                p2.removeCard();
                return jogar(p1,p2);
            }
    }

}