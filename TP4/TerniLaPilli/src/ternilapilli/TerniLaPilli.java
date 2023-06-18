package ternilapilli;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TerniLaPilli {
	public static String NOT_CORRECT_TURN_ERROR_MSG = "Not correct turn to play";
	public static String NOT_MORE_PIECES_AVAILABLE_ERROR_MSG = "No more pieces available";
	public static String LOCATION_NOT_AVAILABLE_ERROR_MSG = "Location not available for piece";
	public static String CANNOT_SLIDE_PIECES = "Cannot slide pieces";
	public static String CANNOT_PUT_MORE_PIECES = "Cannot put more pieces";
	public static String ONLY_SLIDE_SORROUNDING_SQUARES = "Only slide sorrounding squares";
	
	private Player turn;
	private List<Piece> piecesX;
	private List<Piece> piecesO;
	
	public TerniLaPilli() {
		turn = new PlayerX();
		piecesX = new ArrayList<>();
		piecesO = new ArrayList<>();
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

	public boolean isPlayingX() {
		return turn.isPlayingX();
	}
	
	public boolean isPlayingO() {
		return turn.isPlayingO();
	}
	
 	public TerniLaPilli putXAt( int row, int column) {
		assert turn.isPlayingX();
		if (isUsedInGame( row, column ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );

		return lookForState().putXAt( this, new Piece( row, column) );
	}
 	
	public TerniLaPilli putOAt(int row, int column) {
		assert turn.isPlayingO();
		if (isUsedInGame( row, column ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );

		return lookForState().putOAt( this, new Piece( row, column) );
	}

	public TerniLaPilli slidePieceXTo(int row, int column, int newRow, int newColumn) {
		assert turn.isPlayingX();
		if ( !(isUsedIn( piecesX(), row, column)) ) 
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG);
		if (isUsedInGame( newRow, newColumn ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
		if (new Piece(row,column).isFar( newRow, newColumn)) 
			throw new RuntimeException( TerniLaPilli.ONLY_SLIDE_SORROUNDING_SQUARES);
		
		return lookForState().slidePieceXTo( this, new Piece (row, column), new Piece (newRow, newColumn) );

	}

	public TerniLaPilli slidePieceOTo(int row, int column, int newRow, int newColumn) {
		assert turn.isPlayingO();
		if ( !(isUsedIn( piecesO(), row, column)) ) 
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG);
		if (isUsedInGame( newRow, newColumn ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
		if (new Piece(row,column).isFar( newRow, newColumn)) 
			throw new RuntimeException( TerniLaPilli.ONLY_SLIDE_SORROUNDING_SQUARES);

		return lookForState().slidePieceOTo( this, new Piece (row, column), new Piece (newRow, newColumn) );
	}
	
	public TerniLaPilli innerPutXAtIn( int row, int column ) {
		turn = addPieceAndNextPlayer( piecesX(), new Piece( row, column ));
		return this;
	}

	public TerniLaPilli innerPutOAt( int row, int column ) {
		turn = addPieceAndNextPlayer( piecesO(), new Piece( row, column ));
		return this;
	}
	
	public Player addPieceAndNextPlayer( List<Piece> pieces, Piece piece) {
		pieces.add( piece );
		return turn.nextPlayer();
	}
	
	public boolean isUsedIn(List<Piece> pieces, int row, int column) {
		return pieces.contains( new Piece (row, column));
	}
	
	public boolean isUsedInGame( int row, int column ) {
		return isUsedIn(allPieces(), row, column);
	}
	
	public boolean isOver() {
		return XhasWon() || OhasWon();
	}

	public boolean OhasWon() {
		return hasPlayerWon( piecesO );
	}

	public boolean XhasWon() {
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
	
	private int currentStateID() {
		return ( isOver() ) ? -1 : allPieces().size();
	}
	
	private State lookForState() {
		return stateArray().stream().filter( (each) -> each.canHandle(currentStateID() ) ).findFirst().get());
	}
	
	private ArrayList<State> stateArray() {
		return new ArrayList<>(Arrays.asList( new StatePut(), new StateSlide(), new StateOver() ) );
	}
}