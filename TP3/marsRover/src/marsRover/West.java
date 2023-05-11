package marsRover;

public class West extends Direction {
	
	public Pointer moveForward() {
		return new Pointer (-1,0);
	}

	public Pointer moveBackward() {
		return new Pointer (1,0);
	}

	public Direction rotateLeft() {
		return new South();
		
	}

	public Direction rotateRight() {
		return new North();
	}
}
