package marsRover;

public class MarsRover {
	
	private Pointer position;
	private Direction direction;
	
	public MarsRover (Pointer initialLocation, Direction initialDirection) {
		position = initialLocation;
		direction = initialDirection;
	}
	
	public MarsRover move(String command) {
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt( i ) == "f".charAt(0)) {
				return moveForward();
			}
			throw new RuntimeException("Comando no valido");
		}
		return this;
	}

	private MarsRover moveForward() {
		position = position.add( direction.moveForward());
		return this;
	}

	public Pointer location() { return position; }	
	public Direction direction() { return direction; }
}