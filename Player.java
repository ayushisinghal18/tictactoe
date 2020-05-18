package tictactoe;

public class Player {
	private char id;
	private char symbol;
	private int totalWins;

	public Player(char symbol) {
		this.symbol = symbol;
		totalWins = 0;
	}

	char getId() {
		return id;
	}

	void setId(char id) {
		this.id = id;
	}

	int getWins() {
		return totalWins;
	}

	void addWins() {
		totalWins++;
	}

	char getSymbol() {
		return symbol;
	}

	void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", symbol=" + symbol + ", totalWins=" + totalWins + "]";
	}

}
