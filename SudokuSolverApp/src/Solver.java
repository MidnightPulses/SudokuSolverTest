
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
	
	private boolean SudokuSolver(int[][]board, int size, int row, int column) {
		if(row==size-1 && column==size)
			return true;
		if (column==size) {
			row++;
			column=0;
		}
		if (board[row][column]!=0)
			return SudokuSolver(board, size, row, column+1);
		
		for (int num =1; num<=size; num++) {
			if(isSafe(board, size, row, column, num, 0)) {
				board[row][column]=num;
				if (SudokuSolver(board, size, row, column+1))
					return true;
				board[row][column]=0;
				
			}
		}
		return false;
	}
    private boolean isSafe(int[][] board, int size, int row, int column, int num, int boxsize) {
        return !usedInRow(board, size, row, num) && !usedInColumn(board, size, column, num) && !usedInBox(board, size, row - boxsize, column - boxsize, num);
    }

    private boolean usedInRow(int[][] board, int size, int row, int num) {
        for (int column = 0; column < size; column++) {
            if (board[row][column] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInColumn(int[][] board, int size, int column, int num) {
        for (int row = 0; row < size; row++) {
            if (board[row][column] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInBox(int[][] board, int size, int row, int column, int num) {
        int boxsize = (int) Math.sqrt(size);
        int startrow = (row / boxsize) * boxsize;
        int startcolumn = (column / boxsize) * boxsize;

        for (int i = 0; i < boxsize; i++) {
            for (int j = 0; j < boxsize; j++) {
                int currentRow = startrow + i;
                int currentColumn = startcolumn + j;
                if (board[currentRow][currentColumn] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}
