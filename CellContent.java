package tictactoe;
/**
 * This class holds the cell content
 * @author ayushi
 *
 */
public enum CellContent {

	EMPTY('\0', "EMPTY"), NOUGHT('O', "NOUGHT"), CROSS('X', "CROSS");

	private final char state;
	private final String value;

	private CellContent(char state, String value) {
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
