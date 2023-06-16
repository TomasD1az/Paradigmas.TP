package ternilapilli;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public abstract class Player {
	
	public abstract boolean canXPlay();
	public abstract boolean canOPlay();
	public abstract boolean isPlayingX();
	public abstract boolean isPlayingO();
	public abstract Player nextPlayer();

}
