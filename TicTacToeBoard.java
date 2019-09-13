

/**
 * 
 * @author Pruthvi 
 * A class for playing Tic Tac Toe game.
 *
 */

public class TicTacToeBoard {

	// instance variables for the class
	private int size = 3;
	private char[][] board = new char[size][size];
	private char currentPlayer;

	/**
	 * 
	 * Constructs a TicTacToeBoard object that initializes the board to '-' values.
	 */

	public TicTacToeBoard() {
		initializeBoard();

	}

	/**
	 * It says who is currently playing the game.
	 * 
	 * @return The current player who is playing the game.
	 */

	public char getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * It sets the current player's name with a character.
	 * 
	 * @param name the character that should be assigned to the current player.
	 */

	public void setCurrentPlayer(char name) {
		this.currentPlayer = name;
	}

	/**
	 * This method initializes the board to '-' values. This method is also called
	 * in the constructor.
	 */

	public void initializeBoard() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				board[i][j] = '-';

		}

	}

	/**
	 * This method changes the player alternatively after each turn.
	 */

	public void changePlayer() {
		if (currentPlayer == 'X')
			currentPlayer = 'O';
		else
			currentPlayer = 'X';
	}

	/**
	 * This method marks a position on the TicTacToe Board.
	 * 
	 * @param row marks the row position.
	 * @param col marks the column position.
	 * @return True, if the position is marked successfully. Otherwise returns
	 *         false.
	 */

	public boolean placeMark(int row, int col) {

		if (currentPlayer == 'X') {
			if (row > -1 && row < 3 && col > -1 && col < 3) {
				if (board[row][col] == '-') {
					board[row][col] = currentPlayer;
					return true;
				}
				if (board[row][col] != '-') {
					System.out.println("That place is already taken.");
				}

			}
		} else {
			if (board[row][col] == '-') {
				board[row][col] = currentPlayer;
				return true;
			}

		}
		return false;

	}

	/**
	 * This method prints the Board of the game.
	 */

	public void printBoard() {

		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {

			System.out.print("| ");

			for (int j = 0; j < 3; j++) {

				System.out.print(board[i][j] + " | ");

			}

			System.out.println();

			System.out.println("-------------");

		}

	}

	/**
	 * This method tells us if the board is full or not.
	 * 
	 * @return true, if the board is full otherwise false.
	 */

	public boolean isBoardFull() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j] == '-')
					return false;

			}
		}
		return true;

	}

	/**
	 * This method tells us if we have a winner or not.
	 * 
	 * @return true, if there is a winner otherwise false.
	 */

	public boolean isWinner() {
		return (checkRows() || checkColumns() || checkDiagonals());

	}

	/**
	 * This method checks for same character on all rows.
	 * 
	 * @return true, if the all the character are same on any given row otherwise
	 *         returns false.
	 */

	public boolean checkRows() {

		for (int i = 0; i < size; i++) {
			if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true)
				return true;
		}
		return false;

	}

	/**
	 * This method checks for same character on all columns.
	 * 
	 * @return true, if the all the character are same on any given column otherwise
	 *         returns false.
	 */

	public boolean checkColumns() {
		for (int i = 0; i < size; i++) {
			if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true)
				return true;
		}
		return false;

	}

	/**
	 * This method checks for the same character on both diagonals.
	 * 
	 * @return true, if the all the characters are same on any given diagonals.
	 *         Otherwise returns false.
	 */

	public boolean checkDiagonals() {
		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true)
				|| (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));

	}

	/**
	 * This method checks if all the parameters are same or not.
	 * 
	 * @param c1 character on the Tic Tac Toe Board.
	 * @param c2 character on the Tic Tac Toe Board.
	 * @param c3 character on the Tic Tac Toe Board.
	 * @return true if c1, c2 and c3 are equivalent. Otherwise returns false.
	 */

	public Boolean checkRowCol(char c1, char c2, char c3) {
		if ((c1 != '-') && (c1 == c2) && (c2 == c3))
			return true;
		else
			return false;

	}

}
