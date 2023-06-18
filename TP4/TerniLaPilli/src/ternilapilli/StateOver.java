package ternilapilli;

public class StateOver extends State {

	public TerniLaPilli putXat() {
		throw new RuntimeException(TerniLaPilli.CANNOT_PUT_MORE_PIECES);
	}

	public TerniLaPilli putOat() {
		throw new RuntimeException(TerniLaPilli.CANNOT_PUT_MORE_PIECES);
	}

	public TerniLaPilli slidePieceXTo() {
		throw new RuntimeException(TerniLaPilli.CANNOT_SLIDE_PIECES);
	}

	public TerniLaPilli slidePieceOTo() {
		throw new RuntimeException(TerniLaPilli.CANNOT_SLIDE_PIECES);
	}

	public boolean canHandle(int id) {
		return id == -1;
	}
}