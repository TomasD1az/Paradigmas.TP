package marsRover;

public class DirectionWest extends Direction {
	
	public Pointer moveForward() {
		return new Pointer (-1,0);
	}

	public Pointer moveBackward() {
		return new Pointer (1,0);
	}

	public Direction rotateLeft() {
		return new DirectionSouth();
		
	}

	public Direction rotateRight() {
		return new DirectionNorth();
	}
}
