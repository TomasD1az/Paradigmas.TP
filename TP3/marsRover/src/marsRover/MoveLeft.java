package marsRover;

public class MoveLeft extends Command{
	private Character id;
	
	public MoveLeft() {
		id = "l".charAt(0);
	}
	public void execute(MarsRover marsrover) {
		marsrover.rotateLeft();
	}
	
	public Character id() {
		return id;
	}
}
