package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	static int uSign, cSign;
	static int board[][] = new int[3][3];
	
	public static void main(String[] args) {
		System.out.println("--Welcome to the Tic Tac Toe Game--");
		createBoard(board);
		select();
		showBoard(board);
	}

	public static void createBoard(int board[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = 0;
			}
		}
	}

	public static void select() {
		System.out.println("Enter 1 for X or 2 for O :");
		Scanner sc = new Scanner(System.in);
		uSign = sc.nextInt();
		cSign = (uSign == 1) ? 2 : 1;
		System.out.println("You Selected : " + ((uSign == 1) ? "X" : "O"));
		System.out.println("Computer is : " + ((cSign == 1) ? "X" : "O"));
		sc.close();
	}
	
	public static void showBoard(int board[][]) {
	
		System.out.println("   "+XorO(board[0][0])+" | "+XorO(board[0][1])+" | "+XorO(board[0][2]));
		System.out.println("----------------");
		System.out.println("   "+XorO(board[1][0])+" | "+XorO(board[1][1])+" | "+XorO(board[1][2]));
		System.out.println("----------------");
		System.out.println("   "+XorO(board[2][0])+" | "+XorO(board[2][1])+" | "+XorO(board[2][2]));
		
		
	}
	
	public static char XorO(int a) {
		if(a==0) {return ' ';}
		return (a==1)?'X':'O';
	}
}