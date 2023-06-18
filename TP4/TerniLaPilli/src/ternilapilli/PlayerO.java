package ternilapilli;

public class PlayerO extends Player {
	
	public boolean isPlayingX() {
		throw new RuntimeException( TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG );
	}
	
	public boolean isPlayingO() {
		return true;
	}

	public Player nextPlayer() {
		return new PlayerX();
	}
}