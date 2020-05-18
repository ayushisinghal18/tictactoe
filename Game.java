package tictactoe;

import java.util.Arrays;

public class Game {

	private int gameId;
	private Player player1;
	private Player player2;
	private char winner;
	private Board board;
	// List<Cell> cells; for undo
	private int[] rowSum;
	private int[] colSum;
	private int diagSum;
	private int revDiagSum;
	private Player currentPlayer;
	private String gameStatus;

	public Game(final int size) {
		board = new Board(size);

		player1 = new Player(PlayerType.NOUGHT.getState());
		player1.setId(PlayerType.NOUGHT.getState());

		player2 = new Player(PlayerType.NOUGHT.getState());
		player2.setId(PlayerType.CROSS.getState());

		rowSum = new int[size];
		colSum = new int[size];

		resetGameBoard();
	}

	// makes a move on the board
	public String makeMove(Cell cell) {

		if (!isValidMove(cell, board)) {
			System.out.println("Move is out of board. Try again !!");
		} else if (!isCellOccupied(cell, board)) {
			System.out.println("Space is already occupied. Try again !!");
		} else {
			updateBoard(cell);
			board.drawBoard();

			if (checkWinner(cell)) {
				winner = currentPlayer.getId();
				changeGameStatus();
				currentPlayer.addWins();
				return getGameStatus();
			}

			changePlayer();
		}
		if (board.isBoardFull()) {
			gameStatus = GameStatus.DRAW.getValue();
			System.out.println("Game is a DRAW");
		}
		return getGameStatus();
	}

	public String getGameStatus() {
		return gameStatus;
	}

	public int getGameId() {
		return gameId;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	// to be implemented later
	public void undo() {

	}

	public char getWinner() {
		return winner;
	}
	
	// resets the game board
	public void resetGameBoard() {
		board.initBoard();

		winner = PlayerType.NONE.getState();
		currentPlayer = player1;
		gameStatus = GameStatus.PLAYING.getValue();

		Arrays.fill(rowSum, 0);
		Arrays.fill(colSum, 0);

		diagSum = 0;
		revDiagSum = 0;
	}
	
	// changes game status
	private void changeGameStatus() {
		if (getWinner() == GameStatus.NOUGHT_WON.getState())
			gameStatus = GameStatus.NOUGHT_WON.getValue();
		else if (getWinner() == GameStatus.CROSS_WON.getState())
			gameStatus = GameStatus.CROSS_WON.getValue();
		else
			gameStatus = GameStatus.PLAYING.getValue();

	}

	// checks if a move is out of game board or not
	private boolean isValidMove(Cell cell, Board board) {
		if (cell.getRow() < 0 || cell.getCol() < 0 || cell.getRow() >= board.getBoardSize()
				|| cell.getCol() >= board.getBoardSize())
			return false;

		return true;
	}

	// checks if move is already occupied or not
	private boolean isCellOccupied(Cell cell, Board board) {
		if (board.getBoard()[cell.getRow()][cell.getCol()].getContent() != CellContent.EMPTY.getState())
			return false;

		return true;
	}

	// checks if a player has won the game or not
	private boolean checkWinner(Cell cell) {

		if (rowCrossed(cell.getRow()) || columnCrossed(cell.getCol()) || diagonalCrossed() || revDiagonalCrossed())
			return true;

		return false;
	}

	private boolean rowCrossed(int rowNum) {
		return board.getBoardSize() == Math.abs(rowSum[rowNum]);
	}

	private boolean columnCrossed(int colNum) {
		return board.getBoardSize() == Math.abs(colSum[colNum]);
	}

	private boolean diagonalCrossed() {
		return board.getBoardSize() == Math.abs(diagSum);
	}

	private boolean revDiagonalCrossed() {
		return board.getBoardSize() == Math.abs(revDiagSum);
	}

	// changes player after every move
	private void changePlayer() {
		currentPlayer = currentPlayer == player1 ? player2 : player1;
	}

	// updates the move on game board after move is validated
	private void updateBoard(Cell cell) {
		char cellContent = currentPlayer.getId() == PlayerType.NOUGHT.getState() ? CellContent.NOUGHT.getState()
				: CellContent.CROSS.getState();
		board.getBoard()[cell.getRow()][cell.getCol()].setContent(cellContent);

		int content = cell.getCellContentValue(currentPlayer.getId());
		rowSum[cell.getRow()] += content;
		colSum[cell.getRow()] += +content;
		if (cell.getRow() == cell.getCol())
			diagSum += content;
		if (cell.getRow() == board.getBoardSize() - 1 - cell.getCol())
			revDiagSum += content;

	}
}
