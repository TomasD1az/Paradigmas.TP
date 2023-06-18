package ternilapilli;

public class Piece {
	public static String INVALID_POSITION_ERROR_MSG = "Invalid Position";
	private int row;
	private int column;
	
	public Piece( int row, int column) {
		if ( rowAndColumnNotBetween1to3(row, column) )  
			 throw new RuntimeException( INVALID_POSITION_ERROR_MSG );
		
		this.row = row;
		this.column = column;
	}
	
	public int row() {
		return row;
	}
	
	public int column() {
		return column;
	}
	
	public boolean equals( Object object ) {
		return object != null 
				&& object.getClass() == this.getClass()
				 && ((Piece) object).row() == row()
				  && ((Piece) object).column() == column();
	}
	
	public boolean areInColumn( Piece otherPiece ) {
		return column() == otherPiece.column();
	}
	
	public boolean areInRow( Piece otherPiece ) {
		return row() == otherPiece.row();
	}
	
	public boolean areInDiagonal( Piece otherPiece ) {
		return ( isInDiagonalEqual() && otherPiece.isInDiagonalEqual() ) || ( isInDiagonalInverse() && otherPiece.isInDiagonalInverse( ));
	}
	
	public boolean isInDiagonalEqual() {
		return row() == column();
	}
	
	public boolean isInDiagonalInverse() {
		return row() + column() == 4;
	}
	
	

	private boolean rowAndColumnNotBetween1to3(int row, int column) {
		return !(numberBetween1To3(row) && numberBetween1To3(column));
	}
 
	private boolean numberBetween1To3(int number) {
		return number >= 1 && number <= 3;
	}

	public boolean isFar(int newRow, int newColumn) {
		return Math.abs(row - newRow) > 1 || Math.abs(column - newColumn) > 1;
	}
}