package marsRover;

public class MoveForward extends Command{
	private Character name;
	private MarsRover marsrover;
	
	public MoveForward( MarsRover theMarsrover ) {
		name = "f".charAt(0);
		marsrover = theMarsrover;
	}
	public void execute() {
		marsrover.moveForward();
	}
	
	public Character name() {
		return name;
	}
}
