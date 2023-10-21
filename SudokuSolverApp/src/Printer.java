
public class Printer {

	public static void PrintBoard(BoardAndReader sudokuboard) {
		int [][]board = sudokuboard.getBoard();
		int size = board.length;
		
		for (int row=0; row<size; row++){
			for(int coloumn=0;coloumn<size; coloumn++) {
				System.out.print(board[row][coloumn]+" ");
				
			}
			System.out.println();
		}
	}
}
