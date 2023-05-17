package marsRover;

public class MoveForward extends Command{
	private Character id;
	
	public MoveForward() {
		id = "f".charAt(0);
	}
	
	public void execute(MarsRover marsrover) {
		marsrover.moveForward();
	}
	
	public Character id() {
		return id;
	}
}
