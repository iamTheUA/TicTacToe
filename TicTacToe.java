package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	static int uSign, cSign;
	static int turn = 9;
	static int board[][] = new int[3][3];

	public static void main(String[] args) {
		System.out.println("--Welcome to the Tic Tac Toe Game--");
		createBoard();
		firstSelect();
		showBoard();
		selectPosition();
		showBoard();
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
		cSign = (uSign == 1) ? 2 : 1;
		System.out.println("You Selected : " + ((uSign == 1) ? "X" : "O"));
		System.out.println("Computer is : " + ((cSign == 1) ? "X" : "O"));
		// sc.close();
	}

	public static void showBoard() {

		System.out.println("   " + XorO(board[0][0]) + " | " + XorO(board[0][1]) + " | " + XorO(board[0][2]));
		System.out.println("----------------");
		System.out.println("   " + XorO(board[1][0]) + " | " + XorO(board[1][1]) + " | " + XorO(board[1][2]));
		System.out.println("----------------");
		System.out.println("   " + XorO(board[2][0]) + " | " + XorO(board[2][1]) + " | " + XorO(board[2][2]));

	}

	public static void selectPosition() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Position--- ");
		System.out.println("Enter Row number: ");
		int row = scan.nextInt() - 1;
		System.out.println("Enter Column number: ");
		int col = scan.nextInt() - 1;
		if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
			if (board[row][col] == 0) {
				board[row][col] = uSign;
			} else {
				System.out.println("Select Empty position!");
			}
		} else {
			System.out.println("Enter only 1,2,3 for Row and Column!");
		}
	}

	public static char XorO(int a) {
		if (a == 0) {
			return ' ';
		}
		return (a == 1) ? 'X' : 'O';
	}
}