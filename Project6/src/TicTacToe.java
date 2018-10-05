import java.util.ArrayList;
import java.util.Arrays;

// Alec Bird
// CSE 274 Section B Fall 2017

/**
 * Describes a dictionary for holding all valid boards of tic tac toe
 * @author Alec
 *
 */
public class TicTacToe {
	
	private Board board;
	private ArrayList<Board> list;
	private ArrayDictionary<Board, Integer> dictionary;
	
	/**
	 * Creates a tic tac toe dictionary
	 */
	public TicTacToe(){
		super();
		this.board = new Board();
		list = new ArrayList<Board>();
		this.dictionary = new ArrayDictionary<Board, Integer>();
		createList(board);
		createDictionary();
	}
	
	/**
	 * Creates a list of all valid boards
	 * @param board a tic tac toe board
	 */
	private void createList(Board board){
		int xCount = board.count("x");
		int oCount = board.count("o");
		int dashCount = board.count("-");
		
		if(xCount + oCount != 9){
		
		for(int j = 0; j < 9; j++){
			Board temp = new Board();
			for(int i = 0; i < board.getArray().length; i++){
				temp.getArray()[i] = board.getArray()[i];
			}
			
			if(temp.getArray()[j].equals("-")){
				if(xCount == oCount){
				temp.getArray()[j] = "x";
				}
				else{
				temp.getArray()[j] = "o";
				}
				if(!list.contains(temp) && temp.winningBoard() == false && dashCount != 0){
				list.add(temp);
				createList(temp);
				}
				}
			}
		}
		}
	
	/**
	 * Creates a dictionary of the boards from a list and finds their best move
	 */
	private void createDictionary(){
		dictionary.add(board, 4);
		for(int i = 0; i < list.size(); i++){
			dictionary.add(list.get(i), bestMove(list.get(i)));
		}
	}
	
	/**
	 * Finds the best move for a given board
	 * @param board the given board
	 * @return an integer representing the best move on the board (0-8)
	 */
	private int bestMove(Board board){
		
		boolean spotFound = false;
		int bestMove = 4;
		
		// Find almost win for x's in rows
		for(int i = 0; i <= 6; i=i+3){
			if(board.xCountRow(i, i+2) == 2){
				bestMove = board.emptySpotRow(i, i+2);
				spotFound = true;
				break;
				}
			}
		
		// Find almost win for x's in columns
		for(int i = 0; i <= 2; i++){
			if(board.xCountCol(i, i+6) == 2){
				bestMove = board.emptySpotCol(i, i+6);
				spotFound = true;
				break;
			}
		}
		
		// Find almost win for x's in diagonals
		for(int i = 0, j = 8; i <= 2; i=i+2, j = j-2){
			if(board.getArray()[4].equals("x")){
				if(board.getArray()[i].equals("x")){
					if(board.getArray()[j].equals("-")){
					bestMove = j;
					spotFound = true;
					}
				}
				else if(board.getArray()[j].equals("x")){
					if(board.getArray()[i].equals("-")){
					bestMove = i;
					spotFound = true;
					} 
				}
			}
		}
		
		// If x's turn and spot found, return winning move
		if(board.count("x") == board.count("o") && spotFound){
			return bestMove;
		}
		
		// Find almost win for o's in rows
		for(int i = 0; i <= 6; i=i+3){
			if(board.oCountRow(i, i+2) == 2){
				bestMove = board.emptySpotRow(i, i+2);
				spotFound = true;
				break;
				}
			}
		// Find almost win for o's in columns
		for(int i = 0; i <= 2; i++){
			if(board.oCountCol(i, i+6) == 2){
				bestMove = board.emptySpotCol(i, i+6);
				spotFound = true;
				break;
			}
		}
		
		// Find almost win for o's in diagonals
		for(int i = 0, j = 8; i <= 2; i=i+2, j = j-2){
			if(board.getArray()[4].equals("o")){
				if(board.getArray()[i].equals("o")){
					if(board.getArray()[j].equals("-")){
						bestMove = j;
						spotFound = true;
						}
				}
				else if(board.getArray()[j].equals("o")){
					if(board.getArray()[i].equals("-")){
						bestMove = i;
						spotFound = true;
						} 
				}
			}
		}
		
		// If no spot found and middle is taken, choose first open spot
		if(spotFound == false && !(board.getArray()[4].equals("-"))){
			for(int i = 0; i < board.getArray().length; i++){
				if(board.getArray()[i].equals("-")){
					return i;
					}
				}
			}
		
		// Return middle of board if no other options
		return bestMove;
		
	}
	
	/**
	 * Get the best move from a given board represented as a string
	 * @param board the given board
	 * @return an integer representing the best move on the board (0-8)
	 */
	public int getBestMove(String board){
		String[] array = new String[9];
		for(int i = 0; i < board.length(); i++){
			array[i] = board.substring(i, i+1);
		}
		Board b = new Board(array);
		for(int i = 0; i <list.size(); i++){
			if(list.get(i).equals(b)){
				return dictionary.getValue(list.get(i));
			}
		}
		
		// If not in dictionary, return not valid answer
		return -1;
		
		
	}
	
	/**
	 * Gets the dictionary
	 * @return the dictionary of tic tac toe boards
	 */
	public ArrayDictionary<Board, Integer> getDictionary() {
		return dictionary;
	}
	
	/**
	 * Converts the list to a string representation 
	 * @return the list as a string
	 */
	public String getList(){
		String str = "[";
		for(Board e : list){
			str = str + e.toString();
		}
		str = str + "]";
		return str;
		
	}
	
	
}
	

	
	

	
	
	
	
	

	

