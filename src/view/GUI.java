package view;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.IGameState;
import util.Settings;
import model.Direction;
import controller.DirectionManager;
import controller.Event;

public class GUI implements IGUI{
	private DirectionManager dm;
	private GraphicRepresentation gr;

	public GUI() {
		gr = new GraphicRepresentation();
		dm = new DirectionManager();
		gr.setPreferredSize(new Dimension(Settings.windowSize, Settings.windowSize));
		setupFrame();
		gr.addKeyListener(dm);
		gr.setFocusable(true);
	}

	public void repaint() {
		gr.repaint();
	}

	public void update(IGameState gs, Event e) {
		updateGraphics(gs, e);
		updateDirection(e);
	}
	
	public Direction getDirection() {
		return dm.getDirection();
	}

	private void setupFrame() {
		JFrame frame = new JFrame(Settings.windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setContentPane(gr);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(dm);
	}
	private void updateGraphics(IGameState gs, Event e) {
		gr.updateGameState(gs);
		if (e.win)
			gr.win();
		if (e.loss)
			gr.loose();
		repaint();
	}
	
	private void updateDirection(Event e) {
		if (e.hasMoved)
			dm.updateDirection();
	}

}
