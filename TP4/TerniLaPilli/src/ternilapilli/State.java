package ternilapilli;

public abstract class State {

	public abstract boolean canHandle(int size);
	protected abstract TerniLaPilli putOAt(TerniLaPilli terniLaPilli, Piece piece);
	protected abstract TerniLaPilli putXAt(TerniLaPilli terniLaPilli, Piece piece);
	protected abstract TerniLaPilli slidePieceOTo(TerniLaPilli terniLaPilli, Piece piece, Piece piece2);
	protected abstract TerniLaPilli slidePieceXTo(TerniLaPilli terniLaPilli, Piece piece, Piece piece2);
}