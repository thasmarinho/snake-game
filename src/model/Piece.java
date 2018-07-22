package model;

public class Piece {
	private int x, y;
	
	public Piece(int x, int y) {
		validParameters(x, y);
		this.x = x;
		this.y = y;
	}
	
	private void validParameters(int x, int y) {
		if (x < 0 || y < 0)
			throw new IllegalArgumentException("Illegal Parameters! x: " + x + " y: " + y);
	}
	
	@Override
	public boolean equals(Object o) {
		if ((o instanceof Piece) == false)
			return false;
		else 
			return (this.x == ((Piece)o).x && this.y == ((Piece)o).y);
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
