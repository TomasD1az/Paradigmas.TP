package marsRover;

import java.util.ArrayList;

public class MarsRover {
	
	private Pointer position;
	private Direction direction;
	
	public MarsRover (Pointer initialLocation, Direction initialDirection) {
		position = initialLocation;
		direction = initialDirection;
	}
	
	public MarsRover move(String command) {
		for (int i = 0; i < command.length(); i++) {
			lookForCommand( command.charAt(i) ).execute();
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
	
	public Command lookForCommand( Character character ) {
		for (Command command : commandArray()) {
			if (command.name() == character) 
				return command;
		}
		throw new RuntimeException("No command found with given character");
	}

	public Pointer location() { return position; }	
	public Direction direction() { return direction; }
	
	private ArrayList<Command> commandArray() {
		ArrayList<Command> commands = new ArrayList<Command>();
		commands.add(new MoveForward( this ));
		commands.add(new MoveBackwards( this ));
		commands.add(new MoveRight( this ));
		commands.add(new MoveLeft( this ));
		return commands;
	}
}