package ternilapilli;

public class StateSlide extends State {

	public TerniLaPilli putXat() {
		throw new RuntimeException(TerniLaPilli.CANNOT_PUT_MORE_PIECES);
	}

	public TerniLaPilli putOat() {
		throw new RuntimeException(TerniLaPilli.CANNOT_PUT_MORE_PIECES);
	}

	public TerniLaPilli slidePieceXTo() {
		return null; //falta
	}

	public TerniLaPilli slidePieceOTo() {
		return null; //falta
	}

	public boolean canHandle(int id) {
		return id == 6;
	}
}