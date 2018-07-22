package model;

import java.util.List;

import model.Piece;

public interface IGameState {
	public Piece getFood();
	public List<Piece> getSnake();
	public void removeTail();
	public void addNewHead(Piece f);
	public Piece getHead();
	public int getWidth();
	public int getHeight();
	public void spawnFood();
	public Piece getTail();
}