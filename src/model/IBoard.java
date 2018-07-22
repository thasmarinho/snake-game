package model;

import model.Piece;

public interface IBoard {
	public Piece getFood();
	public Snake getSnake();
	public int getScore();
	public int getWidth();
	public int getHeight();
	public void spawnFood();
}