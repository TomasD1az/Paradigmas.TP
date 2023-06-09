package ternilapilli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TerniLaPilliTest {

	@Test void test01GameStartsWithNoPiecesInTheBoard() {
		TerniLaPilli game = new TerniLaPilli();
		assertTrue( game.piecesX().isEmpty() );
		assertTrue( game.piecesO().isEmpty() );
	}
	
	@Test void test02GameStartsPlayerXTurn() {
		assertTrue( new TerniLaPilli().isPlayingX() );
	}
	
	@Test void test03GameStartsNotPlayerOTurn() {
		assertFalse( new TerniLaPilli().isPlayingO() );
	}
	
	

}
