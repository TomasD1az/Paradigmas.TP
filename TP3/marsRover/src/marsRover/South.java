package marsRover;

public class South extends Direction {

	public Pointer moveForward() {
		return new Pointer (0,-1);
	}

	public Pointer moveBackward() {
		return new Pointer (0,1);
	}

	public Direction moveLeft() {
		return new East();	
	}

	public Direction moveRight() {
		return new West();
	}
}