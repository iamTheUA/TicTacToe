package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static int uSign, cSign;
	static int turnLeft = 9;
	static int nextGame = 0;
	static boolean turn, toPlay = true;
	static int board[][] = new int[3][3];

	public static void main(String[] args) {
		System.out.println("--Welcome to the Tic Tac Toe Game--");
		do {
			playing();
			Scanner sc = new Scanner(System.in);
			System.out.println("Want to play More?");
			System.out.println("Enter 1 for new match");
			System.out.println("Enter 0 to Exit");
			nextGame = sc.nextInt();
		} while (nextGame == 1);
	}

	public static void playing() {
		createBoard();
		showBoard();
		turn = toss();
		if (turn) {
			System.out.println("Your Turn First");
			System.out.println();
			firstSelect();
			showBoard();
		} else {
			System.out.println("Computer's Turn First");
			System.out.println();
			firstSelect();
			showBoard();
			toPlay = false;
		}
		while (turnLeft > 0) {
			if (toPlay) {
				System.out.println();
				System.out.println("----Your Turn----");
				selectPosition();
				toPlay = false;
			} else {
				System.out.println();
				System.out.println("----Computer's Turn---- ");
				compMove();
				toPlay = true;
			}
			System.out.println();
			showBoard();
			turnLeft--;
			checkWin();
		}
	}

	public static void createBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = 0;
			}
		}
	}

	public static void firstSelect() {
		System.out.println("Enter 1 for X or 2 for O :");
		Scanner sc = new Scanner(System.in);
		uSign = sc.nextInt();
		if(uSign==1 || uSign==2) {
		cSign = (uSign == 1) ? 2 : 1;
		System.out.println("You Selected : " + ((uSign == 1) ? "X" : "O"));
		System.out.println("Computer is : " + ((cSign == 1) ? "X" : "O"));
		System.out.println();
		}
		else {
			System.out.println("Enter 1 or 2 only!");
			firstSelect();
		}
	}

	public static void showBoard() {

		System.out.println("   " + XorO(board[0][0]) + " | " + XorO(board[0][1]) + " | " + XorO(board[0][2]));
		System.out.println("----------------");
		System.out.println("   " + XorO(board[1][0]) + " | " + XorO(board[1][1]) + " | " + XorO(board[1][2]));
		System.out.println("----------------");
		System.out.println("   " + XorO(board[2][0]) + " | " + XorO(board[2][1]) + " | " + XorO(board[2][2]));

	}

	public static void showBoardInNumbers() {
		System.out.println();
		System.out.println("[1][1] | [1][2] | [1][3]");
		System.out.println("-----------------------");
		System.out.println("[2][1] | [2][2] | [2][3]");
		System.out.println("------------------------");
		System.out.println("[3][1] | [3][2] | [3][3]");
		System.out.println("     [Row][Col]");
	}

	public static void selectPosition() {
		Scanner scan = new Scanner(System.in);
		showBoardInNumbers();
		System.out.println("----Enter the Position---- ");
		System.out.println("Enter Row number: ");
		int row = scan.nextInt() - 1;
		System.out.println("Enter Column number: ");
		int col = scan.nextInt() - 1;
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			if (board[row][col] == 0) {
				board[row][col] = uSign;
			} else {
				System.out.printf("Select Empty position!%n%n");
				selectPosition();
			}
		} else {
			System.out.printf("Enter only 1,2,3 for Row and Column!%n%n");
			selectPosition();
		}
	}

	public static char XorO(int a) {
		if (a == 0) {
			return ' ';
		}
		return (a == 1) ? 'X' : 'O';
	}

	public static boolean toss() {
		Random rand = new Random();
		int num = rand.nextInt(2);
		if (num == 1) {
			return true;
		} else
			return false;
	}

	public static void checkWin() {

		if (board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
			if (board[0][0] == uSign) {
				playerWon();
			} else if (board[0][0] == cSign)
				CompWon();
		} else if (board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
			if (board[1][0] == uSign) {
				playerWon();
			} else if (board[1][0] == cSign)
				CompWon();
		} else if (board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
			if (board[2][0] == uSign) {
				playerWon();
			} else if (board[2][0] == cSign)
				CompWon();
		} else if (board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
			if (board[0][0] == uSign) {
				playerWon();
			} else if (board[0][0] == cSign)
				CompWon();
		} else if (board[1][1] == board[0][1] && board[0][1] == board[2][1]) {
			if (board[1][1] == uSign) {
				playerWon();
			} else if (board[1][1] == cSign)
				CompWon();
		} else if (board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
			if (board[0][2] == uSign) {
				playerWon();
			} else if (board[0][2] == cSign)
				CompWon();
		} else if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			if (board[0][0] == uSign) {
				playerWon();
			} else if (board[0][0] == cSign)
				CompWon();
		} else if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if (board[0][2] == uSign) {
				playerWon();
			} else if (board[0][2] == cSign)
				CompWon();
		}

		if (turnLeft == 0) {
			System.out.println();
			System.out.println("It's Tie");
			showBoard();
		}
	}

	public static void playerWon() {
		System.out.println();
		System.out.println("You Won!!");
		turnLeft = 0;
		showBoard();
	}

	public static void CompWon() {
		System.out.println();
		System.out.println("Computer Won!!");
		turnLeft = 0;
		showBoard();
	}

	public static void compMove() {

		if (board[0][0] == board[0][1] && board[0][0] == cSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[0][0] == board[0][2] && board[0][0] == cSign && board[0][1] == 0) {
			board[0][1] = cSign;
		} else if (board[0][1] == board[0][2] && board[0][1] == cSign && board[0][0] == 0) {
			board[0][0] = cSign;
		} else if (board[1][0] == board[1][1] && board[1][0] == cSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[1][0] == board[1][2] && board[1][0] == cSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[1][1] == board[1][2] && board[1][1] == cSign && board[1][0] == 0) {
			board[1][0] = cSign;
		} else if (board[2][0] == board[2][1] && board[2][0] == cSign && board[2][2] == 0) {
			board[2][2] = cSign;
		} else if (board[2][0] == board[2][2] && board[2][0] == cSign && board[2][1] == 0) {
			board[2][1] = cSign;
		} else if (board[2][1] == board[2][2] && board[2][1] == cSign && board[2][0] == 0) {
			board[2][0] = cSign;
		} else if (board[0][0] == board[1][0] && board[0][0] == cSign && board[2][0] == 0) {
			board[2][0] = cSign;
		} else if (board[0][0] == board[2][0] && board[0][0] == cSign && board[1][0] == 0) {
			board[1][0] = cSign;
		} else if (board[2][0] == board[1][0] && board[1][0] == cSign && board[0][0] == 0) {
			board[0][0] = cSign;
		} else if (board[0][1] == board[1][1] && board[0][1] == cSign && board[2][1] == 0) {
			board[2][1] = cSign;
		} else if (board[0][1] == board[2][1] && board[0][1] == cSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[2][1] == board[1][1] && board[1][1] == cSign && board[0][1] == 0) {
			board[0][1] = cSign;
		} else if (board[0][2] == board[1][2] && board[0][2] == cSign && board[2][2] == 0) {
			board[2][2] = cSign;
		} else if (board[0][2] == board[2][2] && board[0][2] == cSign && board[1][2] == 0) {
			board[1][2] = cSign;
		} else if (board[2][2] == board[1][2] && board[1][2] == cSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[0][0] == board[1][1] && board[0][0] == cSign && board[2][2] == 0) {
			board[2][2] = cSign;
		} else if (board[0][0] == board[2][2] && board[0][0] == cSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[2][2] == board[1][1] && board[1][1] == cSign && board[0][0] == 0) {
			board[0][0] = cSign;
		} else if (board[0][2] == board[1][1] && board[1][1] == cSign && board[2][0] == 0) {
			board[2][0] = cSign;
		} else if (board[2][0] == board[2][0] && board[2][0] == cSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[2][0] == board[1][1] && board[2][0] == cSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[0][0] == board[0][1] && board[0][0] == uSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[0][0] == board[0][2] && board[0][0] == uSign && board[0][1] == 0) {
			board[0][1] = cSign;
		} else if (board[0][1] == board[0][2] && board[0][1] == uSign && board[0][0] == 0) {
			board[0][0] = cSign;
		} else if (board[1][0] == board[1][1] && board[1][0] == uSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[1][0] == board[1][2] && board[1][0] == uSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[1][1] == board[1][2] && board[1][1] == uSign && board[1][0] == 0) {
			board[1][0] = cSign;
		} else if (board[2][0] == board[2][1] && board[2][0] == uSign && board[2][2] == 0) {
			board[2][2] = cSign;
		} else if (board[2][0] == board[2][2] && board[2][0] == uSign && board[2][1] == 0) {
			board[2][1] = cSign;
		} else if (board[2][1] == board[2][2] && board[2][1] == uSign && board[2][0] == 0) {
			board[2][0] = cSign;
		} else if (board[0][0] == board[1][0] && board[0][0] == uSign && board[2][0] == 0) {
			board[2][0] = cSign;
		} else if (board[0][0] == board[2][0] && board[0][0] == uSign && board[1][0] == 0) {
			board[1][0] = cSign;
		} else if (board[2][0] == board[1][0] && board[1][0] == uSign && board[0][0] == 0) {
			board[0][0] = cSign;
		} else if (board[0][1] == board[1][1] && board[0][1] == uSign && board[2][1] == 0) {
			board[2][1] = cSign;
		} else if (board[0][1] == board[2][1] && board[0][1] == uSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[2][1] == board[1][1] && board[1][1] == uSign && board[0][1] == 0) {
			board[0][1] = cSign;
		} else if (board[0][2] == board[1][2] && board[0][2] == uSign && board[2][2] == 0) {
			board[2][2] = cSign;
		} else if (board[0][2] == board[2][2] && board[0][2] == uSign && board[1][2] == 0) {
			board[1][2] = cSign;
		} else if (board[2][2] == board[1][2] && board[1][2] == uSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[0][0] == board[1][1] && board[0][0] == uSign && board[2][2] == 0) {
			board[2][2] = cSign;
		} else if (board[0][0] == board[2][2] && board[0][0] == uSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[2][2] == board[1][1] && board[1][1] == uSign && board[0][0] == 0) {
			board[0][0] = cSign;
		} else if (board[0][2] == board[1][1] && board[1][1] == uSign && board[2][0] == 0) {
			board[2][0] = cSign;
		} else if (board[2][0] == board[2][0] && board[2][0] == uSign && board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[2][0] == board[1][1] && board[2][0] == uSign && board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[0][0] == 0) {
			board[0][0] = cSign;
		} else if (board[0][2] == 0) {
			board[0][2] = cSign;
		} else if (board[2][0] == 0) {
			board[2][0] = cSign;
		} else if (board[2][2] == 0) {
			board[2][2] = cSign;
		} else if (board[1][1] == 0) {
			board[1][1] = cSign;
		} else if (board[0][1] == 0) {
			board[0][1] = cSign;
		} else if (board[1][0] == 0) {
			board[1][0] = cSign;
		} else if (board[1][2] == 0) {
			board[1][2] = cSign;
		} else if (board[2][1] == 0) {
			board[2][1] = cSign;
		} else
			System.out.println("Error!");
	}
}