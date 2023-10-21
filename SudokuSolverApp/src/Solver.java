
public class Solver {

	private BoardAndReader sudokuboard;
	
	public Solver(BoardAndReader sudokuboard) {
		this.sudokuboard = sudokuboard;
		
	}
	
	public boolean SudokuSolver() {
		int[][]board = sudokuboard.getBoard();
		int size = sudokuboard.getSize();
		return SudokuSolver(board, size, 0, 0);
	}
	
	private boolean SudokuSolver(int[][]board, int size, int row, int coloumn) {
		if(row==size-1 && coloumn==size)
			return true;
		if (coloumn==size) {
			row++;
			coloumn=0;
		}
		if (board[row][coloumn]!=0)
			return SudokuSolver(board, size, row, coloumn+1);
		
		for (int num =1; num<=size; num++) {
			if(isSafe(board, size, row, coloumn, num)) {
				board[row][coloumn]=num;
				if (SudokuSolver(board, size, row, coloumn+1))
					return true;
				board[row][coloumn]=0;
				
			}
		}
		return false;
	}
    private boolean isSafe(int[][] board, int size, int row, int coloumn, int num) {
        return !usedInRow(board, size, row, num) && !usedInColoumn(board, size, coloumn, num) && !usedInBox(board, size, row - row % 3, coloumn - coloumn % 3, num);
    }

    private boolean usedInRow(int[][] board, int size, int row, int num) {
        for (int coloumn = 0; coloumn < size; coloumn++) {
            if (board[row][coloumn] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInColoumn(int[][] board, int size, int coloumn, int num) {
        for (int row = 0; row < size; row++) {
            if (board[row][coloumn] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInBox(int[][] board, int size, int boxStartRow, int boxStartCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int coloumn = 0; coloumn < 3; coloumn++) {
                if (board[row + boxStartRow][coloumn + boxStartCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

}
