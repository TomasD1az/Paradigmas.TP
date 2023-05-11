package marsRover;

public class Pointer {
	private int x;
	private int y;
	
	public Pointer(int xCoordinate, int yCoordinate) {
		x = xCoordinate;
		y = yCoordinate;
	}
	
	public Pointer add( Pointer newCoordinate) {
		return new Pointer( x+newCoordinate.x(), y+newCoordinate.y() );
	}

	public boolean equals(Object obj) {
		return obj != null && ( this.getClass() == getClass() ) && (x == ((Pointer) obj).x() && y == ((Pointer)obj).y() );
		}

	public int x() { return x; }
	public int y() { return y; }
}