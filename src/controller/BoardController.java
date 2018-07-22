package controller;
import java.util.concurrent.TimeUnit;

import model.Direction;
import model.Board;
import model.IBoard;
import model.Piece;
import model.Snake;
import util.Settings;
import view.IGUI;

public class BoardController {
	private IGUI gui;
	private IBoard gameState;
	private Snake snake;

	public BoardController(IGUI gui) {
		this.gui = gui;
		this.gameState = new Board();
		this.snake = gameState.getSnake();
	}

	public void play() {
		Event event = null;
		long start;
		long elapsed;
		long wait;

		do {
			start = System.nanoTime();

			//Do work
			event = step();
			gui.update(gameState, event);

			//Fps Stuff
			elapsed = System.nanoTime() - start;
			wait = TimeUnit.NANOSECONDS.toMillis(((TimeUnit.SECONDS.toNanos(1)/Settings.ticksPerSecond) - elapsed));

			if (wait < 0)
				wait = 5;
			try {
				Thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!event.win && !event.loss);
	}

	private Event step() {
		Event.EventFactory eventFactory = new Event.EventFactory();
		if(isGameWon())
			eventFactory.setWin(true);
		else if (isLegalMove() == false)
			eventFactory.setLoss(true);
		else {
			Piece moveTo = move(snake.getHead(), gui.getDirection());
			snake.addNewHead(moveTo);
			eventFactory.setMovementDirection(gui.getDirection());

			if (moveTo.equals(gameState.getFood())) {
				gameState.spawnFood();
				eventFactory.setPickedUpFood(true);
			} else
				snake.removeTail();
		}
		return eventFactory.buildEvent();
	}

	private boolean isGameWon() {
		int snakeSize = snake.getPieces().size();
		
		return (snakeSize == Settings.pieceWidth * Settings.pieceLength);
	}

	private boolean isLegalMove() {
		Direction d = gui.getDirection();
		Piece head = snake.getHead();
		if (head.getX() + d.getX() < 0 || head.getX() + d.getX() >= Settings.windowSize || head.getY() + d.getY() < 0 || head.getY() + d.getY() >= Settings.windowSize)
			return false;
		if (snake.containsPiece(move(head, d)) && !snake.getTail().equals(move(head, d)))
			return false;
		return true;
	}

	private Piece move(Piece p, Direction newDirection) {
		return new Piece(p.getX() + newDirection.getX(), p.getY() + newDirection.getY());
	}
}
