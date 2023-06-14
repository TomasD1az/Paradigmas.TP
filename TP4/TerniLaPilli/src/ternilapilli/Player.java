package ternilapilli;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public abstract class Player {
	protected List<Piece> pieces;
	private Player otherPlayer;
	
	public Player() {
		pieces = new ArrayList<Piece>();
	}
	
	public void setOtherPlayer( Player player ) {
		otherPlayer = player;
	}

	public List<Piece> pieces() {
		return pieces;
	}
	
	public Player otherPlayer() {
		return otherPlayer;
	}
	
	public boolean isUsed( int row, int column ) {
		return piecesUsedByPlayers().contains( new Piece( row, column ) );
	}
	
	public List<Piece> piecesUsedByPlayers() {
		List<Piece> piecesUsed = new ArrayList<>( pieces() );
		piecesUsed.addAll( otherPlayer.pieces() ); 
		return piecesUsed;
	}
	
	public abstract Player putXAt( int row, int column );
	public abstract Player putOAt( int row, int column );
	public abstract boolean isPlayingX();
	public abstract boolean isPlayingO();
	
	public abstract Player slideRightPieceXIn( int row, int column );

}
