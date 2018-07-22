package model;

import java.util.LinkedList;

public class Snake {
	public final int INITIAL_SIZE = 3;
	private LinkedList<Piece> snakePieces;
	
	public Snake() {
		this.snakePieces = new LinkedList<Piece>();
		snakePieces.add(new Piece(2, 0));
		snakePieces.add(new Piece(1, 0));
		snakePieces.add(new Piece(0, 0));
	}
	
	public void removeTail() {
		snakePieces.removeLast();
	}
	
	public void addNewHead(Piece p) {
		snakePieces.addFirst(p);
	}
	public Piece getHead() {
		return snakePieces.getFirst();
	}
	public Piece getTail() {
		return snakePieces.getLast();
	}
	public boolean containsPiece(Piece p) {
		return snakePieces.contains(p);
	}
	public LinkedList<Piece> getPieces(){
		return snakePieces;
	}
	
}
