package marsRover;

public abstract class Direction {
	
	public abstract Pointer moveForward();
	public abstract Pointer moveBackward();
	public abstract Direction rotateLeft();
	public abstract Direction rotateRight();
	
	public boolean equals(Object obj) {
		return obj != null &&( this.getClass() == getClass() );
		}
	}