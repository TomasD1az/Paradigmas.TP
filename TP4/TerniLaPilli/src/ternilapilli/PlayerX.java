package ternilapilli;

public class PlayerX extends Player {
	
	public boolean isPlayingX() {
		return true;
	}

	public boolean isPlayingO() {
		throw new RuntimeException( TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG );
	}
	
	public Player nextPlayer() {
		return new PlayerO();
	}
}