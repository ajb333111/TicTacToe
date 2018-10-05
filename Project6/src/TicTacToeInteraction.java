import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Alec Bird
// CSE 274 Section B Fall 2017

public class TicTacToeInteraction {
	
	public static void main(String[] args){
		
		// Create a new tic tac toe dictionary
		TicTacToe test = new TicTacToe();
		
		int counter = 0;
		String[] array = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
		Board b = new Board(array);
		Scanner in = new Scanner(System.in);
		while(test.getDictionary().contains(b) && b.count("-") != 0){
			if(counter % 2 == 0){
				System.out.println("Enter a number between 0-8: ");
				String entry = in.nextLine();
				int move = Integer.parseInt(entry);
				array[move] = "x";
			}
			else{
				System.out.println("Computer's move:\n");
				b.getArray()[test.getDictionary().getValue(b)] = "o";
			}
			printBoard(b);
			counter++;
		}
		if(b.count("x") > b.count("o") && b.winningBoard()){
			System.out.println("X WINS!");
		}
		else if(b.count("o") == b.count("x") && b.winningBoard()){
			System.out.println("O WINS!");
		}
		else{
			System.out.println("TIE!");
		}
	
	}
	
	private static void printBoard(Board b){
		for(int i = 0; i < b.getArray().length; i++){
			System.out.print(b.getArray()[i]);
			if(i==2||i==5||i==8){
				System.out.println("\n");
			}
		}
	}
}
