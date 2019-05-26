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
    }

    @BeforeClass
    public static void darcartas(){
        p1.takeCard(c1);
        p1.takeCard(c1);
        p1.takeCard(c4);
        p2.takeCard(c3);
        p2.takeCard(c1);
        p2.takeCard(c2);
    }

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



}