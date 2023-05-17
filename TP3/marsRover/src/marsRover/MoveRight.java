package marsRover;

public class MoveRight extends Command{
	private Character id;
	
	public MoveRight() {
		id = "r".charAt(0);
	}
	public void execute(MarsRover marsrover) {
		marsrover.rotateRight();
	}
	
	public Character id() {
		return id;
	}
}
