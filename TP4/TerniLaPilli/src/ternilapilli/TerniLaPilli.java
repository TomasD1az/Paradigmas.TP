package ternilapilli;

import java.util.List;

public class TerniLaPilli {
	public static String NOT_CORRECT_TURN_ERROR_MSG = "Not correct turn to play";
	public static String NOT_MORE_PIECES_AVAILABLE_ERROR_MSG = "No more pieces available";
	public static String LOCATION_NOT_AVAILABLE_ERROR_MSG = "Location not available for piece";
	
	private PlayerX playerX;
	private PlayerO playerO;
	private Player turn;
	
	public TerniLaPilli() {
		playerX = new PlayerX();
		playerO = new PlayerO();
		
		playerX.setOtherPlayer(playerO);
		playerO.setOtherPlayer(playerX);
		turn = playerX;
		
	}

	public List<Piece> piecesX() {
		return playerX.pieces();
	}

	public List<Piece> piecesO() {
		return playerO.pieces();
	}

	public boolean isPlayingX() {
		return turn.isPlayingX();
	}
	
	public boolean isPlayingO() {
		return turn.isPlayingO();
	}

	public TerniLaPilli putXAt( int row, int column ) {
		turn = turn.putXAt( row, column );
		return this;
	}

	public TerniLaPilli putOAt( int row, int column ) {
		turn = turn.putOAt( row, column );
		return this;
	}

	public TerniLaPilli slideRightPieceXIn( int row, int column ) {
		turn = turn.slideRightPieceXIn( row, column );
		return this;
	}

}
