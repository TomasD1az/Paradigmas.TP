package marsRover;

public class DirectionNorth extends Direction {

	public Pointer moveForward() {
		return new Pointer (0,1);
	}

	public Pointer moveBackward() {
		return new Pointer (0,-1);
	}

	public Direction rotateLeft() {
		return new DirectionWest();	
	}

	public Direction rotateRight() {
		return new DirectionEast();
	}
}