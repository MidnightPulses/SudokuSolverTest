import java.util.Scanner;
import java.io.File;

public class MainExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int boardsize = BoardsizePrompt();
		String inputfilepath = InputfilePrompt();
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

	}
	
	private static int BoardsizePrompt() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter board size:");
		int boardsize = scanner.nextInt();
		return boardsize;
	}
	
	private static String InputfilePrompt() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter input file path");
		String inputfilepath = scanner.nextLine();
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


