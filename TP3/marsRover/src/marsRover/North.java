package marsRover;

public class North extends Direction {

	public Pointer moveForward() {
		return new Pointer (0,1);
	}

	public Pointer moveBackward() {
		return new Pointer (0,-1);
	}

	public Direction moveLeft() {
		return new West();
		
	}

	public Direction moveRight() {
		return new East();
	}
}