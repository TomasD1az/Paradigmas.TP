package marsRover;

public class DirectionEast extends Direction {
	
	public Pointer moveForward() {
		return new Pointer (1,0);
	}

	public Pointer moveBackward() {
		return new Pointer (-1,0);
	}

	public Direction rotateLeft() {
		return new DirectionNorth();
		
	}

	public Direction rotateRight() {
		return new DirectionSouth();
	}
}
