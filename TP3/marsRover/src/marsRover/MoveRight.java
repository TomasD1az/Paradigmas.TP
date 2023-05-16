package marsRover;

public class MoveRight extends Command{
	private Character name;
	private MarsRover marsrover;
	
	public MoveRight( MarsRover theMarsrover ) {
		name = "r".charAt(0);
		marsrover = theMarsrover;
	}
	public void execute() {
		marsrover.rotateRight();
	}
	
	public Character name() {
		return name;
	}
}
