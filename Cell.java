package tictactoe;

public class Cell {
	private int row;
	private int col;
	private char content;

	public Cell(int r, int c) {
		row = r;
		col = c;
		content = CellContent.EMPTY.getState();
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public char getContent() {
		return content;
	}

	public void setContent(char content) {
		this.content = content;
	}

	//get the cell value based on player type
	public int getCellContentValue(char content) {
		return content == PlayerType.NOUGHT.getState() ? 1 : -1;
	}
}
