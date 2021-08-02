package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	static int uSign, cSign;
	static int board[][] = new int[3][3];
	
	public static void main(String[] args) {
		System.out.println("--Welcome to the Tic Tac Toe Game--");
		createBoard(board);
	}

	public static void createBoard(int board[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public static void Select() {
		System.out.println("Enter 1 for X or 2 for O :");
		Scanner sc = new Scanner(System.in);
		uSign = sc.nextInt();
		cSign = (uSign == 1) ? 2 : 1;
		System.out.print("You Selected" + ((uSign == 1) ? "X" : "O"));
		System.out.print("Computer is :" + ((cSign == 2) ? "X" : "O"));
		sc.close();
	}
}