package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	int uSign, cSign;

	public static void main(String[] args) {
		System.out.println("--Welcome to the Tic Tac Toe Game--");
		char board[][] = new char[3][3];
		createBoard(board);
	}

	public static void createBoard(char board[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public static void Select() {
		System.out.println("Enter 1 for X or 2 for O :");
		Scanner sc = new Scanner(System.in);
		int uSign = sc.nextInt();
		int cSign = (uSign == 1) ? 2 : 1;
		System.out.print("You Selected" + ((uSign == 1) ? "X" : "O"));
		System.out.print("Computer is :" + ((cSign == 1) ? "X" : "O"));
		sc.close();
	}
}