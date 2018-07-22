package controller;
import java.util.concurrent.TimeUnit;

import model.Direction;
import model.GameState;
import model.IGameState;
import model.Piece;
import util.Settings;
import view.IGUI;

public class GameEngine {
	IGUI gui;
	IGameState gs;

	public GameEngine(IGUI gui) {
		this.gui = gui;
		this.gs = new GameState();
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
			gui.update(gs, event);

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
			Piece moveTo = move(gs.getHead(), gui.getDirection());
			gs.addNewHead(moveTo);
			eventFactory.setMovementDirection(gui.getDirection());

			if (moveTo.equals(gs.getFood())) {
				gs.spawnFood();
				eventFactory.setPickedUpFood(true);
			} else
				gs.removeTail();
		}
		return eventFactory.buildEvent();
	}

	private boolean isGameWon() {
		return (gs.getSnake().size() == Settings.pieceWidth * Settings.pieceLength);
	}

	private boolean isLegalMove() {
		Direction d = gui.getDirection();
		Piece head = gs.getHead();
		if (head.getX() + d.getX() < 0 || head.getX() + d.getX() >= Settings.windowSize || head.getY() + d.getY() < 0 || head.getY() + d.getY() >= Settings.windowSize)
			return false;
		if (gs.getSnake().contains(move(head, d)) && !gs.getTail().equals(move(head, d)))
			return false;
		return true;
	}

	private Piece move(Piece p, Direction newDirection) {
		return new Piece(p.getX() + newDirection.getX(), p.getY() + newDirection.getY());
	}
}
