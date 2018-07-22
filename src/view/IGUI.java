package view;

import model.IBoard;
import model.Direction;
import controller.Event;

public interface IGUI {
	public void repaint();
	public void update(IBoard gs, Event e);
	public Direction getDirection();
}
