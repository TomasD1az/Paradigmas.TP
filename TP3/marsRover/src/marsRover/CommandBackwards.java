package marsRover;

public class CommandBackwards extends Command{
	private Character id;
	
	public CommandBackwards() {
		id = "b".charAt(0);
	}
	
	public void execute(MarsRover marsrover) {
		marsrover.moveBackward();
	}
	
	public boolean canHandle(char id) {return id() == id;}
	
	public Character id() {
		return id;
	}
}
