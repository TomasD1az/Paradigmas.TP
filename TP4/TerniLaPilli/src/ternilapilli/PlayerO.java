package ternilapilli;

public class PlayerO extends Player {
	
	public PlayerO() {
		super();
	}

	public boolean canOPlay() {	
		return true;
	}
	
	public boolean canXPlay() {
		throw new RuntimeException( TerniLaPilli.NOT_CORRECT_TURN_ERROR_MSG );
	}

	public boolean isPlayingX() {
		return false;
	}


	public boolean isPlayingO() {
		return true;
	}

	public Player nextPlayer() {
		return new PlayerX();
	}
}
