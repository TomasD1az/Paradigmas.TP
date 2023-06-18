package ternilapilli;

public abstract class State {
	
	public abstract boolean canHandle( int id );
	public abstract TerniLaPilli putXAt( TerniLaPilli game, Piece location );
	public abstract TerniLaPilli putOAt( TerniLaPilli game, Piece location );
	public abstract TerniLaPilli slidePieceXTo( TerniLaPilli game, Piece piece, Piece newLocation );
	public abstract TerniLaPilli slidePieceOTo( TerniLaPilli game, Piece piece, Piece newLocation );
	
}