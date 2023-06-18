package ternilapilli;

public class StatePut extends State {

	public TerniLaPilli putXat() {
		return null; //falta
	}

	public TerniLaPilli putOat() {
		return null; //falta
	}

	public TerniLaPilli slidePieceXTo() {
		throw new RuntimeException(TerniLaPilli.CANNOT_SLIDE_PIECES);
	}

	public TerniLaPilli slidePieceOTo() {
		throw new RuntimeException(TerniLaPilli.CANNOT_SLIDE_PIECES);
	}

	public boolean canHandle(int id) {
		return id >= 0 && id < 6;
	}
}