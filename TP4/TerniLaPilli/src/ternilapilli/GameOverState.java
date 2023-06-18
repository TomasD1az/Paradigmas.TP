package ternilapilli;

public class GameOverState extends State{

	public boolean canHandle(int id) {
		return id == -1;
	}

	@Override
	public TerniLaPilli putXAt(TerniLaPilli game, Piece location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TerniLaPilli putOAt(TerniLaPilli game, Piece location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TerniLaPilli slidePieceXTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TerniLaPilli slidePieceOTo(TerniLaPilli game, Piece piece, Piece newLocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
