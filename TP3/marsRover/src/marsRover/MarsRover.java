package marsRover;

public class MarsRover {
	
	private Pointer position;
	private Direction direction;
	
	public MarsRover (Pointer initialLocation, Direction initialDirection) {
		position = initialLocation;
		direction = initialDirection;
	}
	
	public MarsRover move(String command) {
		new Command( command ).apply( this );
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
	
	public MarsRover stayPut() {
		return this;
	}

	public Pointer location() { return position; }	
	public Direction direction() { return direction; }
}