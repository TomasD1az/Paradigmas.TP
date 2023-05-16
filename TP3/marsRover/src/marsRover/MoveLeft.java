package marsRover;

public class MoveLeft extends Command{
	private Character name;
	private MarsRover marsrover;
	
	public MoveLeft( MarsRover theMarsrover ) {
		name = "l".charAt(0);
		marsrover = theMarsrover;
	}
	public void execute() {
		marsrover.rotateLeft();
	}
	
	public Character name() {
		return name;
	}
}
