package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Direction;
import util.Settings;

public class DirectionManager implements KeyListener{
	Direction currentDirection;
	Direction nextDirection;

	public DirectionManager() {
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
			System.out.println("esquerda");
			break;
		case KeyEvent.VK_RIGHT:
			nextDirection = Direction.RIGHT;
			System.out.println("direita");
			break;
		case KeyEvent.VK_UP:
			nextDirection = Direction.UP;
			System.out.println("para cima!");
			break;
		case KeyEvent.VK_DOWN:
			nextDirection = Direction.DOWN;
			System.out.println("para baixo!");
			break;
		}}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
}
