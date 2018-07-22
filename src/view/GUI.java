package view;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.IBoard;
import util.Settings;
import model.Direction;
import controller.DirectionController;
import controller.Event;

public class GUI implements IGUI{
	private DirectionController dc;
	private BoardView view;

	public GUI() {
		view = new BoardView();
		dc = new DirectionController();
		view.setPreferredSize(new Dimension(Settings.windowSize, Settings.windowSize));
		setupFrame();
		view.addKeyListener(dc);
		view.setFocusable(true);
	}

	public void repaint() {
		view.repaint();
	}

	public void update(IBoard board, Event e) {
		updateGraphics(board, e);
		updateDirection(e);
	}
	
	public Direction getDirection() {
		return dc.getDirection();
	}

	private void setupFrame() {
		JFrame frame = new JFrame(Settings.windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setContentPane(view);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(dc);
	}
	private void updateGraphics(IBoard board, Event e) {
		view.updateBoard(board);
		if (e.win)
			view.win();
		if (e.loss)
			view.loose();
		repaint();
	}
	
	private void updateDirection(Event e) {
		if (e.hasMoved)
			dc.updateDirection();
	}

}
