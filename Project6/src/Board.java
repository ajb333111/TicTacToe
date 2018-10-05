// Alec Bird
// CSE 274 Section B Fall 2017

import java.util.Arrays;

/**
 * Describes a tic tac toe board
 * @author Alec
 *
 */
public class Board {
	
	private String[] array;

	/**
	 * Creates an empty tic tac toe board
	 */
	public Board() {
		super();
		this.array = new String[9];
		createBoard(this.array);
	}
	
	/**
	 * Creates a new tic tac toe board from the given string array
	 * @param array the array to be converted to a board
	 */
	public Board(String[] array){
		super();
		this.array = array;
	}
	
	/**
	 * Initializes the board by putting dashes representing an empty board
	 * @param board the given array to be made a board
	 */
	private void createBoard(String[] board){
		for(int i = 0; i < board.length; i++){
			board[i] = "-";
		}
	}
	
	/**
	 * Counts a specific string in an array
	 * @param s the string to be counted
	 * @return the number of times the string was in the array
	 */
	public int count(String s){
		int count = 0;
		for(int i = 0; i <array.length; i++){
			if(array[i].equals(s)){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Finds an empty spot in a row
	 * @param start where to start searching
	 * @param end where to end searching
	 * @return an integer representing the empty spot
	 */
	public int emptySpotRow(int start, int end){
		for(int i = start; i <= end; i++){
			if(array[i].equals("-"))
				return i;
		}
		return 0;
	}
	
	/**
	 * Finds an empty spot in a column
	 * @param start where to start searching
	 * @param end where to end searching
	 * @return an integer representing the empty spot
	 */
	public int emptySpotCol(int start, int end){
		for(int i = start; i <= end; i =i+3){
			if(array[i].equals("-"))
				return i;
		}
		return 0;
	}
	
	/**
	 * Counts the number of x's in a row
	 * @param start where to start searching
	 * @param end where to end searching
	 * @return the amount of x's
	 */
	public int xCountRow(int start, int end){
		int count = 0;
		for(int i = start; i <= end; i++){
			if(array[i].equals("x")) //count and make sure there is a dash
				count++;
			if(array[i].equals("o"))
				count--;
		}
		return count;
	}
	
	/**
	 * Counts the number of o's in a row
	 * @param start where to start searching
	 * @param end where to end searching
	 * @return the amount of o's
	 */
	public int oCountRow(int start, int end){
		int count = 0;
		for(int i = start; i <= end; i++){
			if(array[i].equals("o"))
				count++;
			if(array[i].equals("x"))
				count--;
		}
		return count;
	}

	/**
	 * Counts the number of x's in a column
	 * @param start where to start searching
	 * @param end where to end searching
	 * @return the amount of x's
	 */
	public int xCountCol(int start, int end){
		int count = 0;
		for(int i = start; i <= end; i=i+3){
			if(array[i].equals("x"))
				count++;
			if(array[i].equals("o"))
				count--;
		}
		return count;
		
	}
	
	/**
	 * Counts the number of o's in a column
	 * @param start where to start searching
	 * @param end where to end searching
	 * @return the amount of o's
	 */
	public int oCountCol(int start, int end){
		int count = 0;
		for(int i = start; i <= end; i=i+3){
			if(array[i].equals("o"))
				count++;
			if(array[i].equals("x"))
				count--;
		}
		return count;
		
	}
	
	/**
	 * Checks if a board is a winning board
	 * @return true if the board is a winning board, false if not
	 */
	public boolean winningBoard(){
		for(int i = 0; i <= 6; i=i+3){
			if(xCountRow(i, i+2) == 3){
				return true;
				}
			}
		for(int i = 0; i <= 2; i++){
			if(xCountCol(i, i+6) == 3){
				return true;
				}
			}
		
		
		for(int i = 0, j = 8; i <= 2; i=i+2, j = j-2){
			if(getArray()[4].equals("x")){
				if(getArray()[i].equals("x")){
					if(getArray()[j].equals("x")){
						return true;
						}
					}
				}
			}
		
		for(int i = 0; i <= 6; i=i+3){
			if(oCountRow(i, i+2) == 3){
				return true;
				}
			}
		
		for(int i = 0; i <= 2; i++){
			if(oCountCol(i, i+6) == 3){
				return true;
				}
			}
		
		for(int i = 0, j = 8; i <= 2; i=i+2, j = j-2){
			if(getArray()[4].equals("o")){
				if(getArray()[i].equals("o")){
					if(getArray()[j].equals("o")){
						return true;
						}
					}
				}
			}
		return false;
		}
		
	
	/**
	 * Gets the string array
	 * @return
	 */
	public String[] getArray() {
		return array;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}

	/**
	 * Hashcode for the equals method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	/**
	 * Compares boards 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		return true;
	}
	
	
	
	
	


}
