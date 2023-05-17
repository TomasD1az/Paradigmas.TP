package marsRover;

public class CommandNull extends Command {

	private Character id;
	
	public CommandNull() {
		this.id = null;
	}
	public void execute(MarsRover marsrover) {
		throw new RuntimeException("No command found with given character");
	}

	public boolean canHandle(char id) {
		return false;
	}

	public Character id() {
		return id;
	}
}