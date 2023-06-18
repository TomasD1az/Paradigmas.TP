package ternilapilli;

public class SlidePieceState extends State{

	public boolean canHandle(int id) {
		return id == 6;
	}

	public TerniLaPilli putXAt(TerniLaPilli game, Piece location) {
		throw new RuntimeException( TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG );
	}

	public TerniLaPilli putOAt(TerniLaPilli game, Piece location) {
		throw new RuntimeException( TerniLaPilli.NOT_MORE_PIECES_AVAILABLE_ERROR_MSG );
	}

	public TerniLaPilli slidePieceXTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	public TerniLaPilli slidePieceOTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
