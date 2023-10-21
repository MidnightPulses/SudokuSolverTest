import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BoardAndReader {
	
	private int[][] board;
	private int boardsize;
	
	public BoardAndReader(int boardsize) {
		this.boardsize = boardsize;
		this.board = new int[boardsize][boardsize];			
		}
	public void BoarderLoader(String filepath) {//it rhymes
		try (BufferedReader BfR = new BufferedReader(new FileReader(filepath))){
			for (int row=0; row<boardsize; row++) {
				String[]rowvalues = BfR.readLine().split(" ");
				for(int coloumn =0; coloumn<boardsize; coloumn++) {
					board[row][coloumn]=Integer.parseInt(rowvalues[coloumn]);
				}
			}
			
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
 
	public int getSize() {
		return boardsize;
	}
	public int [][]getBoard(){
		return board;
	}
}
	