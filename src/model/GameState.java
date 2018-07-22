package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


import util.Settings;


public class GameState implements IGameState{
	private int width, height;
	private LinkedList<Piece> snake;
	private Food food;
	private Random r = new Random();


	public GameState(int width, int height, LinkedList<Piece> snake, Food food) {
		this.width = width;
		this.height = height;
		this.snake = snake;
		this.food = food;
	}

	public GameState() {
		this.width = Settings.pieceWidth;
		this.height = Settings.pieceLength;
		this.snake = new LinkedList<Piece>();
		snake.add(new Piece(3, 0));
		snake.add(new Piece(2, 0));
		snake.add(new Piece(1, 0));
		snake.add(new Piece(0, 0));
		this.food = new Food(10, 0);
	}

	public Piece getFood() {
		return food;
	}

	public List<Piece> getSnake() {
		return snake;
	}

	public void removeTail() {
		snake.removeLast();
	}

	public void addNewHead(Piece f)  {
		snake.addFirst(f);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Piece getHead() {
		return snake.getFirst();
	}

	public void spawnFood() {
		List<Food> possibleSpawns = new LinkedList<Food>();
		for (int i = 0; i < Settings.pieceWidth; i++)
			for (int j = 0; j < Settings.pieceLength; j++) {
				Food f = new Food(i, j);
				if (!snake.contains(f))
					possibleSpawns.add(f);
			}
		food = possibleSpawns.get(r.nextInt(possibleSpawns.size()));
	}

	public Piece getTail() {
		return snake.getLast();
	}
	
}
