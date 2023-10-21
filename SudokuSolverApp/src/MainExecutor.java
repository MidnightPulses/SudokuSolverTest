
public class MainExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int boardsize = 9;//for now
		BoardAndReader sudokuboard = new BoardAndReader(boardsize);
		sudokuboard.BoarderLoader("C:\\Users\\Dunja Computers\\Desktop\\SudokuBoard1.txt");
	
		Solver solver = new Solver(sudokuboard);
		boolean isSolved = solver.SudokuSolver();
		
		if(isSolved) {
			System.out.println("Board is solved.");
			Printer.PrintBoard(sudokuboard);
		}
		else {
			System.out.println("Board is impossible");
		}
	}

}
