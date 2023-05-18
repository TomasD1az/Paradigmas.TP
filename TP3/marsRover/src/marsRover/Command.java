package marsRover;

public abstract class Command {
	protected Character id;
	public static String INVALID_COMMAND_ERROR = "No command found with given character";
	public abstract void execute(MarsRover marsrover);
	public abstract boolean canHandle(char id);
	public abstract Character id();
}