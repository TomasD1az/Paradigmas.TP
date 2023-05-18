package marsRover;

public class CommandNull extends Command {
	
	public CommandNull() {
		this.id = null;
	}
	public void execute(MarsRover marsrover) {
		throw new RuntimeException(INVALID_COMMAND_ERROR);
	}

	public boolean canHandle(char id) {
		return false;
	}

	public Character id() {
		return id;
	}
}