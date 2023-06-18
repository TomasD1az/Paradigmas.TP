package ternilapilli;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TerniLaPilli {
	public static String NOT_CORRECT_TURN_ERROR_MSG = "Not correct turn to play";
	public static String NOT_MORE_PIECES_AVAILABLE_ERROR_MSG = "No more pieces available";
	public static String LOCATION_NOT_AVAILABLE_ERROR_MSG = "Coordinates are not available or do not exist";
	public static String CANNOT_SLIDE_PIECES_ERROR_MSG = "Cannot slide pieces";
	public static String CANNOT_PUT_MORE_PIECES_ERROR_MSG = "Cannot put more pieces";
	public static String ONLY_SLIDE_SORROUNDING_SQUARES_ERROR_MSG = "Only slide sorrounding squares";
	
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
		checkPutConditions(row, column);

		return lookForState().putXAt( this, new Piece( row, column) );
	}
 	
	public TerniLaPilli putOAt(int row, int column) {
		assert turn.isPlayingO();
		checkPutConditions(row, column);

		return lookForState().putOAt( this, new Piece( row, column) );
	}
	
	public TerniLaPilli innerPutXAt( Piece piece ) {
		turn = addPieceAndNextPlayer( piecesX(), piece);
		return this;
	}

	public TerniLaPilli innerPutOAt( Piece piece ) {
		turn = addPieceAndNextPlayer( piecesO(), piece );
		return this;
	}

	public TerniLaPilli slidePieceXTo(int row, int column, int newRow, int newColumn) {
		assert turn.isPlayingX();
		checkSlidingConditions( piecesX(), row, column, newRow, newColumn );
		
		return lookForState().slidePieceXTo( this, new Piece (row, column), new Piece (newRow, newColumn) );

	}

	public TerniLaPilli slidePieceOTo(int row, int column, int newRow, int newColumn) {
		assert turn.isPlayingO();
		checkSlidingConditions( piecesO(), row, column, newRow, newColumn );

		return lookForState().slidePieceOTo( this, new Piece (row, column), new Piece (newRow, newColumn) );
	}
	
	public boolean isPieceUsedInX(int row, int column) {
		return isPieceUsedIn( piecesX(), row, column);
	}
	
	public boolean isPieceUsedInO(int row, int column) {
		return isPieceUsedIn( piecesO(), row, column);
	}
	
	public boolean isPieceUsedInGame( int row, int column ) {
		return isPieceUsedIn(allPieces(), row, column);
	}
	
	public boolean isPieceUsedIn(List<Piece> pieces, int row, int column) {
		return pieces.contains( new Piece (row, column));
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
		if ( pieces.size() < 3 )
			return false;
		return checkColumnsIn( pieces ) || checkRows( pieces ) || checkDiagonals( pieces );
	}
	
	private int currentStateID() {
		return ( isOver() ) ? -1 : allPieces().size();
	}
	
	private State lookForState() {	
		return listStates().stream().filter( (state) -> state.canHandle( currentStateID() )).findFirst().get();
	}

	private List<State> listStates() {
		return new ArrayList<State>( Arrays.asList( new PutPieceState(), new SlidePieceState(), new GameOverState() ));
	}
	
	public void checkPutConditions(int row, int column) {
		if (isPieceUsedInGame( row, column ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
	}
	
	public void checkSlidingConditions(List<Piece> pieces, int row, int column, int newRow, int newColumn) {
		if ( (isPieceNotIn( pieces, row, column )) || (isPieceUsedInGame( newRow, newColumn )) ) ;
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG);
		
		if (new Piece(row,column).isFar( newRow, newColumn)) 
			throw new RuntimeException( TerniLaPilli.ONLY_SLIDE_SORROUNDING_SQUARES_ERROR_MSG);
	}
	
	public Player addPieceAndNextPlayer( List<Piece> pieces, Piece piece) {
		pieces.add( piece );
		return turn.nextPlayer();
	}
	
	private boolean isPieceNotIn( List<Piece> pieces, int row, int column ) {
		return !(isPieceUsedIn( pieces, row, column));
	}
	
}