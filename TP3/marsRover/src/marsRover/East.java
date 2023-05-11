package marsRover;

public class East extends Direction {
	
	public Pointer moveForward() {
		return new Pointer (1,0);
	}

	public Pointer moveBackward() {
		return new Pointer (-1,0);
	}

	public Direction rotateLeft() {
		return new North();
		
	}

	public Direction rotateRight() {
		return new South();
	}
}
