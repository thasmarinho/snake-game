package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Direction;
import util.Settings;

public class DirectionController implements KeyListener{
	Direction currentDirection;
	Direction nextDirection;

	public DirectionController() {
		this.currentDirection = Settings.defaultDirection;
		this.nextDirection = Settings.defaultDirection;
	}

	public Direction getDirection() {
		return nextDirection;
	}

	public void updateDirection() {
		this.currentDirection = nextDirection;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			nextDirection = Direction.LEFT;
			System.out.println("left");
			break;
		case KeyEvent.VK_RIGHT:
			nextDirection = Direction.RIGHT;
			System.out.println("right");
			break;
		case KeyEvent.VK_UP:
			nextDirection = Direction.UP;
			System.out.println("up!");
			break;
		case KeyEvent.VK_DOWN:
			nextDirection = Direction.DOWN;
			System.out.println("down!");
			break;
		}
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
}
