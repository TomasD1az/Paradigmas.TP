package ternilapilli;

public class PlayerX extends Player {
	
	public PlayerX() {
		super();
	}
	
	public boolean canXPlay() {
		return true;
	}

	public boolean canOPlay() {
		throw new RuntimeException( TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG );
	}

	public boolean isPlayingX() {
		return true;
	}

	public boolean isPlayingO() {
		return false;
	}
	
	public Player nextPlayer() {
		return new PlayerO();
	}

}
