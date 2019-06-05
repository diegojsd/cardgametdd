import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import cardgame_tdd.*;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GameTest {
    static Game game;
    static Player p1;
    static Player p2;
    static Card c1;
    static Card c2;
    static Card c3;
    static Card c4;
    static Dealer d1;

    @BeforeClass
    public static void iniciajogo(){
        game = new Game();
        p1 = new Player("p1");
        p2 = new Player("p2");
        game.addPlayer(p1);
        game.addPlayer(p2);
        c1 = new Card(Suit.SPADES,Rank.TWO);
        c2 = new Card(Suit.DIAMONDS,Rank.FOUR);
        c3 = new Card(Suit.HEARTS,Rank.FIVE);
        c4 = new Card(Suit.HEARTS,Rank.SEVEN);
        p1.takeCard(c1);
        p1.takeCard(c1);
        p1.takeCard(c4);
        p2.takeCard(c3);
        p2.takeCard(c1);
        p2.takeCard(c2);
        game.dealGame();
        d1 = game.getDealer();
    }

    /*@BeforeClass
    public static void darcartas(){
        p1.takeCard(c1);
        p1.takeCard(c1);
        p1.takeCard(c4);
        p2.takeCard(c3);
        p2.takeCard(c1);
        p2.takeCard(c2);
    }*/

    /*@Test
    public void testhandvalue(){
        int handvalue = p1.getHandValue();
        assertEquals(11,handvalue);

    }*/

    @Test
    public void testplayername(){
        String name = p1.getName();
        assertEquals("p1",name);

    }

    /*@Test
    public void testcardvalue(){
        int cardvalue = p1.getCardValue();
        assertEquals(2,cardvalue);
    }*/

    @Test
    public void testcountplayer(){
        int numplayers = game.countPlayers();
        assertEquals(2,numplayers);
    }

    @Test //test for p2 win
    public void testjogar1(){
        Player ganhador = game.jogar(p1, p2);
        assertEquals(p2,ganhador);
    }

    @Test //test for p1 win
    public void testjogar2(){
        Player ganhador = game.jogar(p1, p2);
        assertEquals(p1,ganhador);
    }

    @Test
    public void testCheckWinner(){
        String winner = game.checkWinner();
        assertEquals("Someone wins",winner);
    }

    @Test
    public void testGetSuit(){
        Suit nipe = c3.getSuit();
        assertEquals(Suit.HEARTS,nipe);
    }

    @Test
    public void testGetRank(){
        Rank number = c3.getRank();
        assertEquals(Rank.FIVE,number);
    }

    @Test
    public void testUnshuffled(){
        int unshuffled = d1.countUnshuffledCards();
        assertEquals(52,unshuffled);

    }

    @Test
    public void testCountCard(){
        int count = d1.countCards();
        assertEquals(50,count);

    }
}