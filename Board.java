package tictactoe;

public class Board {
	private Cell[][] cells;
	private int boardSize;

	public Board(final int size) {
		boardSize = size;
		cells = new Cell[size][size];
	}

	//create the game board
	public void initBoard() {
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				cells[r][c] = new Cell(r, c);
				cells[r][c].setContent(CellContent.EMPTY.getState());
			}
		}
	}

	//draw the game board
	void drawBoard() {
		for (int r = 0; r < boardSize; r++) {
			System.out.print(" | ");
			for (int c = 0; c < boardSize; c++) {
				System.out.print(cells[r][c].getContent() + " | ");
			}
			if (r != boardSize - 1)
				System.out.println("\n ------------");
		}

		System.out.println("\n");
	}

	//check if game board is full
	boolean isBoardFull() {
		for (int r = 0; r < boardSize; r++) {
			for (int c = 0; c < boardSize; c++) {
				if (cells[r][c].getContent() == CellContent.EMPTY.getState())
					return false;
			}
		}
		return true;
	}

	public Cell[][] getBoard() {
		return cells;
	}

	public int getBoardSize() {
		return boardSize;
	}

	void clearBoard() {
		initBoard();
	}
}
