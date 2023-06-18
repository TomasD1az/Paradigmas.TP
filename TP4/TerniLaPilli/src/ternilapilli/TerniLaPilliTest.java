package ternilapilli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TerniLaPilliTest {

	@Test void test0GameStartsWithNoPiecesInTheBoard() {
		TerniLaPilli game = new TerniLaPilli();
		assertTrue( game.piecesX().isEmpty() );
		assertTrue( game.piecesO().isEmpty() );
	}
	
	@Test void test0GameStartsPlayerXTurn() {
		assertTrue( new TerniLaPilli().isPlayingX() );
	}
	
	@Test void test0GameStartsNotPlayerOTurn() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> new TerniLaPilli().isPlayingO() );
	}
	
	@Test void test0PutXOnBoardInGivenPosition() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 );
		assertTrue( game.isPieceUsedInX( 1, 1 ));  
	}
	
	@Test void test0PutOOnBoardInGivenPosition() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 ).putOAt(2, 2);
		assertTrue( game.isPieceUsedInO( 2, 2 )); 
	}
	
	@Test void test0PlayerOTurnAfterPlayingX() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 );
		assertTrue( game.isPlayingO() );
	}
	
	@Test void test0PlayerXTurnAfterPlayingO() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 ).putOAt(2, 2);
		assertTrue( game.isPlayingX() );
	}
	
	@Test void test0ErrorThrownWhenPutOPieceFirst() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> new TerniLaPilli().putOAt( 1, 1 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPlayTwoTimesWithX() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 );
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> game.putXAt( 1, 2 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPlayTwoTimesWithO() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 ).putOAt( 2, 1 );
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> game.putOAt( 1, 2 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPlaceAOPieceOnTopOfAPieceX() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 );
		assertThrowsLike( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG, () -> game.putOAt( 1, 1 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPlaceAXPieceOnTopOfAPieceO() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 ).putOAt(2, 2);
		assertThrowsLike( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG, () -> game.putXAt( 2, 2 ));
	}
	
	@Test void test0PutPieceThrowsErrorWhenLocationDoesNotExist() {
		assertThrowsLike( Piece.INVALID_POSITION_ERROR_MSG, () -> new TerniLaPilli().putXAt( 51, 1 ));
	}
	
	@Test void test0SlideDoesNotWorkBefore6PiecesOnBoard() {
		TerniLaPilli game = new TerniLaPilli().putXAt( 1, 1 ).putOAt(1, 2);
		assertThrowsLike( TerniLaPilli.CANNOT_SLIDE_PIECES_ERROR_MSG, () -> game.slidePieceXTo( 1, 1, 2, 2 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPut4XPiecesInBoard() {
		TerniLaPilli game = fullTerniLaPilliGame();
		assertThrowsLike(TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG, () -> game.putXAt( 3, 1 ));
	}
	
	@Test void test0ErrorThrownWhenTryingToPut4OPiecesInBoard() {
		TerniLaPilli game = fullTerniLaPilliGame().slidePieceXTo( 2, 2, 2, 3);	
		assertThrowsLike(TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG, () -> game.putOAt( 3, 1 ));
	}
	
	@Test void test0GameIsOverWhenPutting3PiecesInALine() {
		TerniLaPilli game = gameWithXWinner();
		assertTrue( game.isOver() );
	}
	
	@Test void test0GameIsNotOverWhenNotInLine() {
		TerniLaPilli game = fullTerniLaPilliGame();
		assertFalse( game.isOver() );
	}
	
	@Test void test0XWonWhenPutting3PiecesXInALine() {
		TerniLaPilli game = gameWithXWinner();
		assertTrue( game.hasXWon() );
	}
	
	@Test void test0ODidNotWinWhenPutting3PiecesXInALine() {
		TerniLaPilli game = gameWithXWinner();
		assertFalse( game.hasOWon() );
	}
	
	@Test void test0SlidePiecesXMovesPieceToAnotherLocation() {
		TerniLaPilli game = fullTerniLaPilliGame().slidePieceXTo( 2, 2, 2, 3);
		assertTrue( game.isPieceUsedInX( 2, 3 ));  
	}
	
	@Test void test0SlidePiecesOMovesPieceToAnotherLocation() {
		TerniLaPilli game = fullTerniLaPilliGame().slidePieceXTo( 2, 2, 2, 3).slidePieceOTo(3, 3, 3, 2);
		assertTrue( game.isPieceUsedInO( 3, 2 ));  
	}
	
	
	private TerniLaPilli fullTerniLaPilliGame() {
		return new TerniLaPilli().putXAt( 1, 1 )
											   .putOAt( 2, 1 )
												.putXAt( 1, 2 )
												 .putOAt( 1, 3 )
												  .putXAt( 2, 2 )
												   .putOAt( 3, 3 );
	}
	
	public TerniLaPilli gameWithXWinner() {
		return new TerniLaPilli().putXAt( 1, 1 )
											   .putOAt( 2, 1 )
												.putXAt( 1, 2 )
												 .putOAt( 2, 2 )
												  .putXAt( 1, 3 );
	}
	
	private void assertThrowsLike(String msg, Executable executable) {
		assertEquals( msg, assertThrows( Exception.class, executable).getMessage() );
	}

}
