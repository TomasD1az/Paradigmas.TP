package marsRover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MarsRover {
	
	private Pointer position;
	private Direction direction;
	
	public MarsRover (Pointer initialLocation, Direction initialDirection) {
		position = initialLocation;
		direction = initialDirection;
	}
	
	public MarsRover move(String command) {
		for (int i = 0; i < command.length(); i++) {
			lookForCommand( command.charAt(i) ).execute( this );
		}
		return this;
	}

	public MarsRover moveForward() {
		position = position.add( direction.moveForward() );
		return this;
	}
	
	public MarsRover moveBackward() {
		position = position.add( direction.moveBackward() );
		return this;
	}
	
	public MarsRover rotateRight() {
		direction = direction.rotateRight();
		return this;
	}
	
	public MarsRover rotateLeft() {
		direction = direction.rotateLeft();
		return this;
	}
	
	public Command lookForCommand( Character id ) {
		return commandArray().stream().filter( (each) -> each.canHandle(id) ).findAny().orElse(new CommandNull());
	}

	public Pointer location() { return position; }	
	public Direction direction() { return direction; }
	
	private ArrayList<Command> commandArray() {
		ArrayList<Command> commands = new ArrayList<Command>(Arrays.asList( new CommandForward(), new CommandBackwards(), new CommandRight(), new CommandLeft()));
		return commands;
	}
}