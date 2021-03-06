package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.Player;
import components.cards.Card;
import components.cards.Deck;

public class CardGameTest {
	private Card testCard = new Card(1, 0);
	private Deck testDeck = new Deck();
	private Player testPlayer = new Player("John Wo");

	// Tests to see if a card is properly created. For this test, should equal Ace
	// of Hearts
	@Test
	public void testCardCreation() throws Exception {
		assertEquals("Ace", testCard.getRank());
		assertEquals("Hearts", testCard.getSuit());
	}

	// Tests to see if a deck creates 52 cards
	@Test
	public void testDeckCreation() throws Exception {
		assertEquals(52, testDeck.size());
	}

	// Tests to see if a new Player has the correct name and has no cards on hand
	// when created. Score should also be zero
	@Test
	public void testPlayerCreation() throws Exception {
		assertEquals("John Wo", testPlayer.getName());
		assertEquals(0, testPlayer.handSize());
		assertEquals(0, testPlayer.getScore());
	}

}