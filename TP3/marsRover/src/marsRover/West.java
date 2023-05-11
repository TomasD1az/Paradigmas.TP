package marsRover;

public class West extends Direction {
	
	public Pointer moveForward() {
		return new Pointer (-1,0);
	}

	public Pointer moveBackward() {
		return new Pointer (1,0);
	}

	public Direction moveLeft() {
		return new South();
		
	}

	public Direction moveRight() {
		return new North();
	}
}
