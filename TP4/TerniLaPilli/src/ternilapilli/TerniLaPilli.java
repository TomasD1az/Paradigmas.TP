package ternilapilli;

import java.util.List;
import java.util.ArrayList;

public class TerniLaPilli {
	public static String NOT_CORRECT_TURN_ERROR_MSG = "Not correct turn to play";
	public static String NOT_MORE_PIECES_AVAILABLE_ERROR_MSG = "No more pieces available";
	public static String LOCATION_NOT_AVAILABLE_ERROR_MSG = "Location not available for piece";
	
	private Player turn;
	private List<Piece> piecesX;
	private List<Piece> piecesO;
	
	public TerniLaPilli() {
		turn = new PlayerX();
		piecesX = new ArrayList<>();
		piecesO = new ArrayList<>();
	}

	public boolean isPlayingX() {
		return turn.isPlayingX();
	}
	
	public boolean isPlayingO() {
		return turn.isPlayingO();
	}
	
	public TerniLaPilli putXAt( int row, int column) {
		return lookForState().putXAt( row, column );
	}

	public TerniLaPilli innerPutXAtIn( int row, int column ) {
		assert turn.canXPlay();
		
		if (isUsed( row, column ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
		
		turn = addPieceAndNextPlayer( piecesX(), new Piece( row, column ));
		return this;
	}

	public TerniLaPilli innerPutOAt( int row, int column ) {
		assert turn.canOPlay();
		
		if (isUsed( row, column ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
		
		turn = addPieceAndNextPlayer( piecesO(), new Piece( row, column ));
		return this;
	}
	
	public List<Piece> piecesX() {
		return piecesX;
	}

	public List<Piece> piecesO() {
		return piecesO;
	}
	
	public List<Piece> allPieces() {
		List<Piece> allPieces = new ArrayList<>( piecesX() );
		allPieces.addAll( piecesO() ); 
		return allPieces;
	}
	
	public Player addPieceAndNextPlayer( List<Piece> pieces, Piece piece) {
		pieces.add( piece );
		return turn.nextPlayer();
	}
	
	public boolean isUsed( int row, int column ) {
		return allPieces().contains( new Piece( row, column ) );
	}
	
	public boolean isOver() {
		return hasXWon() || hasOWon();
	}

	public boolean hasOWon() {
		return hasPlayerWon( piecesO );
	}

	public boolean hasXWon() {
		return hasPlayerWon( piecesX );
	}
	
	private boolean checkDiagonals(List<Piece> pieces) {
		return pieces.get(0).areInDiagonal( pieces.get( 1 )) && pieces.get(1).areInDiagonal( pieces.get( 2 ));
	}

	private boolean checkRows(List<Piece> pieces) {
		return pieces.get(0).areInRow( pieces.get( 1 )) && pieces.get(1).areInRow( pieces.get( 2 ));
	}

	private boolean checkColumnsIn(List<Piece> pieces) {
		return pieces.get(0).areInColumn( pieces.get( 1 )) && pieces.get(1).areInColumn( pieces.get( 2 ));
	}

	public boolean hasPlayerWon( List<Piece> pieces) {
		return checkColumnsIn( pieces ) || checkRows( pieces ) || checkDiagonals( pieces );
	}
	
	private State lookForState() {
		int id = ( isOver() ) ? -1 : allPieces().size();		
		return listStates();
	}

}
