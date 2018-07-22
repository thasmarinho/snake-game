package controller;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import view.GUI;
import view.IGUI;

public class Main {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		IGUI g = new GUI();
		BoardController ge = new BoardController(g);
		ge.play();
	}
}
