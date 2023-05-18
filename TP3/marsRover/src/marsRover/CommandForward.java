package marsRover;

public class CommandForward extends Command{
	
	public CommandForward() {
		id = "f".charAt(0);
	}
	
	public void execute(MarsRover marsrover) {
		marsrover.moveForward();
	}
	
	public boolean canHandle(char id) {return id() == id;}
	
	public Character id() {
		return id;
	}
}
