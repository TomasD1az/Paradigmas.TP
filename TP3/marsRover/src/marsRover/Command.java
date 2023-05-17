package marsRover;

public abstract class Command {
	private Character id;
	public abstract void execute(MarsRover marsrover);
	public abstract boolean canHandle(char id);
	public abstract Character id();
}