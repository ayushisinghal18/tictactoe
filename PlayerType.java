package tictactoe;

/**
 * This class holds the type of player
 * @author ayushi
 *
 */
public enum PlayerType {

	NOUGHT('O', "NOUGHT"), CROSS('X', "CROSS"), NONE('\0', "NONE");

	private final char state;
	private final String value;

	private PlayerType(char state, String value) {
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
