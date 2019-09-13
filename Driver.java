

import java.util.*;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		
		// instance variables 

		Scanner inp = new Scanner(System.in);
		TicTacToeBoard game = new TicTacToeBoard();
		Random rand = new Random();
		Boolean turn = rand.nextBoolean();
		int row;
		int col;
		
		// if turn is true X goes first
		
		if (turn) {
			game.setCurrentPlayer('X');
			System.out.println("You won the Toss! You are X.");
		} else {
			System.out.println("You lost the Toss. You are X.");
			game.setCurrentPlayer('O');
		}
		try {

			do {

				do {
					if (game.getCurrentPlayer() == 'X') {
						game.printBoard();

						// gets the input from the user
						System.out.println("Enter 0 - 2. First row and then column with one space");

						row = inp.nextInt();
						col = inp.nextInt();
					} else {
						
						// generates random value between 0 - 2
						row = rand.nextInt(3);
						col = rand.nextInt(3);

					}

				} while (!game.placeMark(row, col));

				game.changePlayer();
				
              // loop goes on until we have a winner or the board is full
			} while (!game.isWinner() && !game.isBoardFull()); 
			

		} catch (InputMismatchException e) {
			System.out.println(e);
			System.out.println("Please enter numbers.");
			System.exit(0);

		}

		if (game.isBoardFull() && !game.isWinner()) {
			System.out.println("The game was a tie!");
			game.printBoard();
		} else {

			game.printBoard();
			game.changePlayer();
			System.out.println(Character.toUpperCase(game.getCurrentPlayer()) + " Wins!");
		}
		inp.close();

	}

}

/* SAMPLE RUN
 You lost the Toss. You are X.
-------------
| - | - | O | 
-------------
| - | - | - | 
-------------
| - | - | - | 
-------------
Enter 0 - 2. First row and then column with one space
0 0
-------------
| X | - | O | 
-------------
| - | - | - | 
-------------
| - | - | O | 
-------------
Enter 0 - 2. First row and then column with one space
1 2
-------------
| X | - | O | 
-------------
| - | - | X | 
-------------
| O | - | O | 
-------------
Enter 0 - 2. First row and then column with one space
2 1
-------------
| X | - | O | 
-------------
| - | O | X | 
-------------
| O | X | O | 
-------------
O Wins!

 
 
 */
