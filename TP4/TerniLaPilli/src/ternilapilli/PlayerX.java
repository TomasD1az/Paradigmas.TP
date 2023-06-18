package ternilapilli;

public class PlayerX extends Player {

	public boolean isPlayingX() {
		return true;
	}

	public boolean isPlayingO() {
		throw new RuntimeException( TerniLaPilli.LOCATION_NOT_AVAILABLE_ERROR_MSG );
	}

	public Player nextPlayer() {
		return new PlayerO();
	}
}