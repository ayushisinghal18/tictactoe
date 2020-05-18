package tictactoe;

/**
 * This class holds the status of the game
 * @author ayushi
 *
 */
public enum GameStatus {

	NOUGHT_WON('O', "NOUGHT"), CROSS_WON('X', "CROSS"), PLAYING('P', "PLAYING"), DRAW('D', "DRAW");

	private final char state;
	private final String value;

	private GameStatus(char state, String value) {
		this.state = state;
		this.value = value;
	}

	public char getState() {
		return state;
	}

	public String getValue() {
		return value;
	}
}
