package util;

import java.awt.Color;
import java.awt.Font;

import model.Direction;

public class Settings {
	public static Direction defaultDirection = Direction.RIGHT;
	public static int pieceWidth = 20;
	public static int pieceLength = 20;
	public static int windowSize = 400;
	public static String windowName = "Snake I. game";
	public static Color backgroundColor = Color.DARK_GRAY;
	public static Color snakeColor = Color.GREEN;
	public static Color foodColor = Color.RED;
	public static String winMessage = "You Win!";
	public static String lossMessage = "You loose!";
	public static int winMessageOffset = 200;
	public static int lossMessageOffset = 200;
	public static Color winMessageColor = Color.GREEN;
	public static Color lossMessageColor = Color.RED;
	public static int ticksPerSecond = 5;
	public static int winMessageSize = 30;
	public static int winMessageStyle = Font.ITALIC;
	public static int lossMessageSize = 30;
	public static int lossMessageStyle = Font.ITALIC;
}