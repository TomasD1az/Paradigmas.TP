package ternilapilli;

public class GameOverState extends State{

	public boolean canHandle(int id) {
		return id == -1;
	}

	public TerniLaPilli putXAt(TerniLaPilli game, Piece location) {
		throw new RuntimeException( TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG );		
	}

	public TerniLaPilli putOAt(TerniLaPilli game, Piece location) {
		throw new RuntimeException( TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG );
	}

	public TerniLaPilli slidePieceXTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		throw new RuntimeException( TerniLaPilli.CANNOT_SLIDE_PIECES_ERROR_MSG );
	}

	public TerniLaPilli slidePieceOTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		throw new RuntimeException( TerniLaPilli.CANNOT_SLIDE_PIECES_ERROR_MSG );
	}
}