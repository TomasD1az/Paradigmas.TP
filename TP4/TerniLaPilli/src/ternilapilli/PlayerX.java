package ternilapilli;

public class PlayerX extends Player {
	
	public PlayerX() {
		super();
	}

	public Player putXAt( int row, int column ) {
		if (pieces().size() >= 3)
			throw new RuntimeException( TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG );
		
		if (isUsed( row, column ))
			throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
		
		pieces.add( new Piece( row, column ));	
		return otherPlayer();
	}

	public Player putOAt( int row, int column ) {
		throw new RuntimeException( TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG );
	}

	public boolean isPlayingX() {
		return true;
	}

	public boolean isPlayingO() {
		return false;
	}

	@Override
	public Player slideRightPieceXIn( int row, int column ) {
		// TODO Auto-generated method stub
		return null;
	}

}