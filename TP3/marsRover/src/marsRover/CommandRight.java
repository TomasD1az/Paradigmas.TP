package marsRover;

public class CommandRight extends Command{
	private Character id;
	
	public CommandRight() {
		id = "r".charAt(0);
	}
	public void execute(MarsRover marsrover) {
		marsrover.rotateRight();
	}
	
	public boolean canHandle(char id) {return id() == id;}
	
	public Character id() {
		return id;
	}
}
