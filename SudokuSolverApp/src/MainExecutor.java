import java.util.Scanner;
import java.io.File;

public class MainExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner = new Scanner(System.in);
		
		int boardsize = BoardsizePrompt(scanner);
		String inputfilepath = InputfilePrompt(scanner);
		if(!BoardsizeMatch(boardsize, inputfilepath)) {
			System.out.println("Error: board sizes don't match");
			return;
		}
			
			BoardAndReader sudokuboard = new BoardAndReader(boardsize);
			sudokuboard.BoarderLoader(inputfilepath);
	
		Solver solver = new Solver(sudokuboard);
		boolean isSolved = solver.SudokuSolver();
		
		if(isSolved) {
			System.out.println("Board is solved.");
			Printer.PrintBoard(sudokuboard);
			
			String outputfilepath = OutputfilePath(inputfilepath);
			System.out.println("Putput file path: " + outputfilepath);
			Printer.ExportFile(sudokuboard, outputfilepath);
		}
		else {
			System.out.println("Board is impossible");
		}
scanner.close();
	}
	
	private static int BoardsizePrompt(Scanner scanner) {
		System.out.print("Enter board size:");
		int boardsize = scanner.nextInt();
		return boardsize;
	}
	
	private static String InputfilePrompt(Scanner scanner) {
		System.out.print("Enter input file path");
		String inputfilepath = scanner.next();
		return inputfilepath;
	}
	
	private static boolean BoardsizeMatch(int boardsize, String inputfilepath ) {
		BoardAndReader sudokuboard = new BoardAndReader(boardsize);
		try {
			sudokuboard.BoarderLoader(inputfilepath);
			return true;
		}
		catch (Exception e) {
			return false;
			}
		}
	private static String OutputfilePath(String inputfilepath) {
		if (inputfilepath.isEmpty()) {
			System.out.println("Error: invalid path");
			return null;
		}
		File inputfile = new File(inputfilepath);
		String parentpath = inputfile.getParent();
		String inputfilename = inputfile.getName();
		String basename = inputfilename.substring(0, inputfilename.lastIndexOf('.'));
		String extention = inputfilename.substring(inputfilename.lastIndexOf('.'));
		String outputfilename = basename + "_solved" + extention;
		
		String outputfilepath = new File(parentpath, outputfilename).getPath();
	System.out.println("Output file path: " + outputfilepath );
		return outputfilepath;
	} 
	}


