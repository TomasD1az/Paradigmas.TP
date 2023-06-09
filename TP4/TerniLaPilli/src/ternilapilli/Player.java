package ternilapilli;

import java.util.List;
import java.util.ArrayList;

public class Player {
	private List<Pieces> pieces;
	
	public Player() {
		pieces = new ArrayList<Pieces>();
	}

	public List<Pieces> pieces() {
		return pieces;
	}

}
