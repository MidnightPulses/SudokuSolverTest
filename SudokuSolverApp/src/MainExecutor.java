
public class MainExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int boardsize = 9;//for now
		BoardAndReader NewBoard = new BoardAndReader(boardsize);
		NewBoard.BoarderLoader("C:\\Users\\Dunja Computers\\Desktop\\SudokuBoard1.txt");
		//needs a solver
	}

}
