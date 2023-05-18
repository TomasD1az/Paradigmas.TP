package marsRover;

public class CommandLeft extends Command{
	
	public CommandLeft() {
		id = "l".charAt(0);
	}
	public void execute(MarsRover marsrover) {
		marsrover.rotateLeft();
	}
	
	public boolean canHandle(char id) {return id() == id;}
	
	public Character id() {
		return id;
	}
}
