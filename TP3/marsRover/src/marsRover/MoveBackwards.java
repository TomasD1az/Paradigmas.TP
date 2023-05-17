package marsRover;

public class MoveBackwards extends Command{
	private Character id;
	
	public MoveBackwards() {
		id = "b".charAt(0);
	}
	
	public void execute(MarsRover marsrover) {
		marsrover.moveBackward();
	}
	
	public Character id() {
		return id;
	}
}
