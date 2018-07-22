package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


import util.Settings;


public class Board implements IBoard{
	private int width, height;
	private Snake snake;
	private Food food;
	private Random r = new Random();


	public Board(int width, int height, Snake snake, Food food) {
		this.width = width;
		this.height = height;
		this.snake = snake;
		this.food = food;
	}

	public Board() {
		this.width = Settings.pieceWidth;
		this.height = Settings.pieceLength;
		this.snake = new Snake();
		this.food = new Food(10, 0);
	}

	public Piece getFood() {
		return food;
	}

	public Snake getSnake() {
		return snake;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void spawnFood() {
		List<Food> possibleSpawns = new LinkedList<Food>();
		for (int i = 0; i < Settings.pieceWidth; i++)
			for (int j = 0; j < Settings.pieceLength; j++) {
				Food f = new Food(i, j);
				if (snake.containsPiece(f) == false)
					possibleSpawns.add(f);
			}
		food = possibleSpawns.get(r.nextInt(possibleSpawns.size()));
	}

	public int getScore() {
		return (snake.getPieces().size() - snake.INITIAL_SIZE);
	}
	
}
