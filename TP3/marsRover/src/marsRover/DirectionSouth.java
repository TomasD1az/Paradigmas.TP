package marsRover;

public class DirectionSouth extends Direction {

	public Pointer moveForward() {
		return new Pointer (0,-1);
	}

	public Pointer moveBackward() {
		return new Pointer (0,1);
	}

	public Direction rotateLeft() {
		return new DirectionEast();	
	}

	public Direction rotateRight() {
		return new DirectionWest();
	}
}