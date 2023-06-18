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
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> new TerniLaPilli().isPlayingO() );
	}
	
	@Test void test04PutXOnBoardInGivenPosition() {
		assertTrue( gameWithOneXPiece().isPieceUsedInX( 1, 1 ));  
	}
	
	@Test void test05PutOOnBoardInGivenPosition() {
		assertTrue( gameWithTwoPieces().isPieceUsedInO( 2, 2 )); 
	}
	
	@Test void test06PlayerOTurnAfterPlayingX() {
		assertTrue( gameWithOneXPiece().isPlayingO() );
	}
	
	@Test void test07PlayerXTurnAfterPlayingO() {
		assertTrue( gameWithTwoPieces().isPlayingX() );
	}
	
	@Test void test08ErrorThrownWhenPutOPieceFirst() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> new TerniLaPilli().putOAt( 1, 1 ));
	}
	
	@Test void test09ErrorThrownWhenTryingToPlayTwoTimesWithX() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> gameWithOneXPiece().putXAt( 1, 2 ));
	}
	
	@Test void test10ErrorThrownWhenTryingToPlayTwoTimesWithO() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> gameWithTwoPieces().putOAt( 1, 2 ));
	}
	
	@Test void test11ErrorThrownWhenTryingToPlaceAOPieceOnTopOfAPieceX() {
		assertThrowsLike( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG, () -> gameWithOneXPiece().putOAt( 1, 1 ));
	}
	
	@Test void test12ErrorThrownWhenTryingToPlaceAXPieceOnTopOfAPieceO() {
		assertThrowsLike( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG, () -> gameWithTwoPieces().putXAt( 2, 2 ));
	}
	
	@Test void test13PutPieceThrowsErrorWhenLocationDoesNotExist() {
		assertThrowsLike( Piece.INVALID_POSITION_ERROR_MSG, () -> new TerniLaPilli().putXAt( 51, 1 ));
	}
	
	@Test void test14SlideDoesNotWorkBefore6PiecesOnBoard() {
		assertThrowsLike( TerniLaPilli.CANNOT_SLIDE_PIECES_ERROR_MSG, () -> gameWithTwoPieces().slidePieceXTo( 1, 1, 2, 1 ));
	}
	
	@Test void test15ErrorThrownWhenTryingToPut4XPiecesInBoard() {
		assertThrowsLike(TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG, () -> fullTerniLaPilliGame().putXAt( 3, 1 ));
	}
	
	@Test void test16ErrorThrownWhenTryingToPut4OPiecesInBoard() {
		assertThrowsLike(TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG, () -> fullGameWithOneSlide().putOAt( 3, 1 ));
	}
	
	@Test void test17GameIsOverWhenPutting3PiecesInALine() {
		assertTrue( gameWithXWinner().isOver() );
	}
	
	@Test void test18GameIsNotOverWhenNotInLine() {
		assertFalse( fullTerniLaPilliGame().isOver() );
	}
	
	@Test void test19XWonWhenPutting3PiecesXInALine() {
		assertTrue( gameWithXWinner().hasXWon() );
	}
	
	@Test void test20OWonWhenPutting3PiecesXInALine() {
		assertTrue( gameWithOWinner().hasOWon() );
	}
	
	@Test void test21ODidNotWinWhenPutting3PiecesXInALine() {
		assertFalse( gameWithXWinner().hasOWon() );
	}
	
	@Test void test22XDidNotWinWhenPutting3PiecesOInALine() {
		assertFalse( gameWithOWinner().hasXWon() );
	}
	
	@Test void test23SlidePiecesXMovesPieceToAnotherLocation() {
		assertTrue( fullGameWithOneSlide().isPieceUsedInX( 2, 3 ));  
	}
	
	@Test void test24SlidePiecesOMovesPieceToAnotherLocation() {
		assertTrue( fullGameWith2Slides().isPieceUsedInO( 3, 2 ));  
	}
	
	@Test void test25SlideRemovesPreviousXPiece() {
		assertTrue(fullGameWithOneSlide().isPieceNotInX(2, 2));
	}
	
	@Test void test26SlideRemovesPreviousOPiece() {
		assertTrue(fullGameWith2Slides().isPieceNotInO(3, 3));
	}

	@Test void test27PlayerOCannotSlideFirst() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> fullTerniLaPilliGame().slidePieceOTo(3,3,3,2));
	}
	
	@Test void test28PlayerXCannotSlideTwice() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> fullGameWithOneSlide().slidePieceXTo(2,3,3,2));
	}
	
	@Test void test29PlayerOCannotSlideTwice() {
		assertThrowsLike(TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG, () -> fullGameWith2Slides().slidePieceOTo(3,2,2,2));
	}
	
	@Test void test30CannotSlideNonExistentPiece() {
		assertThrowsLike(TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG, () -> fullTerniLaPilliGame().slidePieceXTo(3,2,2,3));
	}
	
	@Test void test31CannotSlideFurtherThan1Distance() {
		assertThrowsLike(TerniLaPilli.ONLY_SLIDE_SORROUNDING_SQUARES_ERROR_MSG, () -> fullTerniLaPilliGame().slidePieceXTo(1,1,3,2));
	}
	
	@Test void test32GameIsOverInSlidingState() {
		assertTrue(gameWithXWinnerSliding().isOver());
	}
	
	@Test void test33XCanWinInSlidingState() {
		assertTrue(gameWithXWinnerSliding().hasXWon());
	}
	
	@Test void test34OCanWinInSlidingState() {
		assertTrue(gameWithOWinnerSliding().hasOWon());
	}
	
	@Test void test35CannotPutPiecesWhenGameIsOver() {
		assertThrowsLike( TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG,() -> gameWithXWinner().putOAt(3, 1));
	}
	
	@Test void test36CannotSlideWhenGameIsOver() {
		assertThrowsLike( TerniLaPilli.CANNOT_SLIDE_PIECES_ERROR_MSG,() -> gameWithOWinnerSliding().slidePieceXTo( 3, 1, 2, 1 ));
	}

	private TerniLaPilli fullTerniLaPilliGame() {
		return gameWithOneXPiece()
											   .putOAt( 2, 1 )
												.putXAt( 1, 2 )
												 .putOAt( 1, 3 )
												  .putXAt( 2, 2 )
												   .putOAt( 3, 3 );
	}
	
	public TerniLaPilli gameWithXWinner() {
		return gameWithOneXPiece()
											   .putOAt( 2, 1 )
												.putXAt( 1, 2 )
												 .putOAt( 2, 2 )
												  .putXAt( 1, 3 );
	}
	
	public TerniLaPilli gameWithOWinner() {
		return gameWithOneXPiece()
											   .putOAt( 1, 2 )
												.putXAt( 1, 3 )
												 .putOAt( 2, 2 )
												  .putXAt( 2, 1 )
												   .putOAt( 3, 2 );
	}
	
	public TerniLaPilli gameWithXWinnerSliding() {
		return fullTerniLaPilliGame()
												.slidePieceXTo(1, 2, 2, 3)
												 .slidePieceOTo(3, 3, 3, 2)
												  .slidePieceXTo(2,3,3,3);
	}
	
	public TerniLaPilli gameWithOWinnerSliding() {
		return fullTerniLaPilliGame()
												.slidePieceXTo( 2, 2, 3, 2 )
												 .slidePieceOTo( 2, 1, 2, 2 )
												  .slidePieceXTo( 3, 2, 3, 1 )
												   .slidePieceOTo( 2, 2, 2, 3 );
	}
	
	public TerniLaPilli gameWithOneXPiece() {
		return new TerniLaPilli().putXAt( 1, 1 );
	}
	
	public TerniLaPilli gameWithTwoPieces() {
		return gameWithOneXPiece().putOAt(2, 2);
	}
	
	public TerniLaPilli fullGameWithOneSlide() {
		return fullTerniLaPilliGame().slidePieceXTo( 2, 2, 2, 3 );
	}
	
	public TerniLaPilli fullGameWith2Slides() {
		return fullGameWithOneSlide().slidePieceOTo(3, 3, 3, 2);
	}
	
	
	private void assertThrowsLike(String msg, Executable executable) {
		assertEquals( msg, assertThrows( Exception.class, executable).getMessage() );
	}
	
}