package ternilapilli;

import java.util.List;

public class TerniLaPilli {
	private Player playerX;
	private Player playerO;
	private String turn;
	
	public TerniLaPilli() {
		playerX = new Player();
		playerO = new Player();
		turn = "X";
	}

	public List<Pieces> piecesX() {
		return playerX.pieces();
	}

	public List<Pieces> piecesO() {
		return playerO.pieces();
	}

	public boolean isPlayingX() {
		return turn == "X";
	}
	
	public boolean isPlayingO() {
		return turn == "O";
	}

}
