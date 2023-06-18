package ternilapilli;

public class PlayerO extends Player {

	public boolean isPlayingX() {
		throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
	}

	public boolean isPlayingO() {
		return true;
	}

	public Player nextPlayer() {
		return new PlayerX();
	}
}