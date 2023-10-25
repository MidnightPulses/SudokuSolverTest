import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	 public static void ExportFile(BoardAndReader sudokuboard, String outputpath) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputpath))) {
	            int[][] board = sudokuboard.getBoard();
	            int size = sudokuboard.getSize();

	            for (int row = 0; row < size; row++) {
	                for (int column = 0; column < size; column++) {
	                    writer.write(board[row][column] + " ");
	                }
	                writer.newLine();
	            }

	            System.out.println("Board saved to: " + outputpath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
