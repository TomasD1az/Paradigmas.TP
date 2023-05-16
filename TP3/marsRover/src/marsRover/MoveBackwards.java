package marsRover;

public class MoveBackwards extends Command{
	private Character name;
	private MarsRover marsrover;
	
	public MoveBackwards( MarsRover theMarsrover ) {
		name = "b".charAt(0);
		marsrover = theMarsrover;
	}
	public void execute() {
		marsrover.moveBackward();
	}
	
	public Character name() {
		return name;
	}
}
