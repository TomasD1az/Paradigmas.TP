package ternilapilli;

public class PutPieceState extends State{

	public boolean canHandle(int id) {
		return (id >= 0) && (id < 6);
	}

	public TerniLaPilli putXAt(TerniLaPilli game, Piece location) {
		return game.innerPutXAt( location );
	}

	public TerniLaPilli putOAt(TerniLaPilli game, Piece location) {
		return game.innerPutOAt( location );
	}

	public TerniLaPilli slidePieceXTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		throw new RuntimeException( TerniLaPilli.CANNOT_SLIDE_PIECES_ERROR_MSG );
	}

	public TerniLaPilli slidePieceOTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		throw new RuntimeException( TerniLaPilli.CANNOT_SLIDE_PIECES_ERROR_MSG );
	}

}