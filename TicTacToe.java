package tictactoe;

import java.util.Scanner;

/**
 * Main class to start the game
 * @author ayushi
 *
 */
public class TicTacToe {

	public static void main(String[] args) {
		TicTacToe tictactoe = new TicTacToe();
		Game game = new Game(3);
		tictactoe.startGame(game);
	}

	void startGame(Game game) {
		Scanner scan = new Scanner(System.in);
		boolean continuePlayingGame = true;

		while (continuePlayingGame) {
			do {
				System.out.println("\nPlayer " + game.getCurrentPlayer().getSymbol() + "'s turn. Select move:");
				int row = scan.nextInt();
				int col = scan.nextInt();
				Cell cell = new Cell(row, col);
				cell.setRow(row);
				cell.setCol(col);

				game.makeMove(cell);
				if (game.getWinner() != PlayerType.NONE.getState())
					System.out.println("\nWinner is Player := " + game.getWinner() + ". Total games won := "
							+ game.getCurrentPlayer().getWins());
			} while (game.getGameStatus().equals(GameStatus.PLAYING.getValue()));

			// ask user to restart game
			System.out.println("\nRestart Game? Y/N ?");
			String restartGame = scan.next();
			if (restartGame.equalsIgnoreCase("Y")) {
				System.out.println("Restarting game . . .");
				continuePlayingGame = true;
				game.resetGameBoard();
			} else if (restartGame.equalsIgnoreCase("N")) {
				System.out.println("\nThank you for playing !!");
				continuePlayingGame = false;
			} else {
				System.out.println("\nInvalid input. Thank you for playing !!");
				continuePlayingGame = false;
			}
		}
	}
}
