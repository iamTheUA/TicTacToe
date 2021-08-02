package TicTacToe;

public class TicTacToe {

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
}