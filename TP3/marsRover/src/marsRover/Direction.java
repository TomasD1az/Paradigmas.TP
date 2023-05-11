package marsRover;

public abstract class Direction {
	
	public abstract Pointer moveForward();
	public abstract Pointer moveBackward();
	public abstract Direction moveLeft();
	public abstract Direction moveRight();
	
	public boolean equals(Object obj) {
		return obj != null &&( this.getClass() == getClass() );
		}
	}