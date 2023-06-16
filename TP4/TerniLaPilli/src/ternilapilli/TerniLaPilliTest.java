package ternilapilli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
	
	@Test void test04PutXOnBoardInGivenPosition() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 );
		assertTrue( game.piecesX().contains( new Piece( 1, 1 ))); 
	}
	
	@Test void test05ErrorThrownWhenPutOPieceFirst() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> new TerniLaPilli().putOAt( 1, 1 ));
	}
	
	@Test void test06ErrorThrownWhenTryingToPlayTwoTimesWithX() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 );
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> game.putXAt( 1, 2 ));
	}
	
	@Test void test07ErrorThrownWhenTryingToPlayTwoTimesWithO() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 ).putOAt( 2, 1 );
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> game.putOAt( 1, 2 ));
	}
	
	@Test void test08ErrorThrownWhenTryingToPlaceAPieceOnTopOfAnother() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 );
		assertThrowsLike( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG, () -> game.putOAt( 1, 1 ));
	}
	
	@Test void test09PutPieceThrowsErrorWhenLocationDoesNotExist() {
		assertThrowsLike( Piece.INVALID_POSITION_ERROR_MSG, () -> new TerniLaPilli().putOAt( 51, 1 ));
	}
	
	@Test void test10SlideDoesNotWorkBefore6PiecesOnBoard() {
		assertThrowsLike( Piece.INVALID_POSITION_ERROR_MSG, () -> new TerniLaPilli().slideRightPieceXIn( 1, 1 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPut4XPiecesInBoard() {
		TerniLaPilli game = fullTerniLaPilliGame();
		assertThrowsLike(TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG, () -> game.putXAt( 3, 1 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPut4OPiecesInBoard() {
		TerniLaPilli game = fullTerniLaPilliGame().slideRightPieceXIn( 2, 2 );
		assertThrowsLike(TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG, () -> game.putOAt( 3, 1 ));
	}

	private TerniLaPilli fullTerniLaPilliGame() {
		return new TerniLaPilli().putXAt( 1, 1 )
											   .putOAt( 2, 1 )
												.putXAt( 1, 2 )
												 .putOAt( 1, 3 )
												  .putXAt( 2, 2 )
												   .putOAt( 3, 3 );
	}
	
	private void assertThrowsLike(String msg, Executable executable) {
		assertEquals( msg, assertThrows( Exception.class, executable).getMessage() );
	}

}
