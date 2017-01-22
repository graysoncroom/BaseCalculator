
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class baseKaddition {
	
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException 
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		// creating space in memory for objects that will be used in main
		Scanner fileInput;
		String inputFileName;
		File inputFile;
		
		// creating space in memory for ints that will be used in main
		int repeat; // how many times to repeat operation
		int number1;
		int number2;
		int sum; // sum of [number1] and [number2]
		int base; // number base to calculate and output in
		
		// calls the method printErrorMessage if there is more or less than one command-line argument
		if(args.length != 1)
			printErrorMessage("Requires file name argument to read from");
		
		// sets the first and only argument as the input file name
		inputFileName = args[0];
		
		// calls the method printErrorMessage if there is no file with the name given as the first command-line argument
		if( !(new File(inputFileName).exists() ))
			printErrorMessage("File does not exist");
		
		// stores the object scanner with the file specified by user for reading file input
		fileInput = new Scanner(new File(inputFileName));
		
		
		// reads, adds, and outputs for every test case while there is still a blank line below the current test case
		while(fileInput.hasNextLine() ){
			
			// checks to see if the text document has another step or just a blank bottom line (as is common)
			if(!fileInput.hasNextInt() ) break;
			
			// stores the number of times we want to repeat the addition, this value comes from the file
			repeat = fileInput.nextInt();
			
			// stores the base number that the numbers are in as well as the base that numbers/sum will be printed
			// upon output
			base = fileInput.nextInt();
			
			// stores the numbers to add and converts them from original base to decimal system
			number1 = fileInput.nextInt(base);
			number2 = fileInput.nextInt(base);
			
			// calls the getSum method to return the sum of the two numbers [repeat] times
			sum = getSum(number1,number2,repeat);
			
			// Outputs the information in a standard fashion
			output(base,number1,number2,sum);
		}
		
		System.out.println();
		
		// close the file input scanner
		fileInput.close();
		
		// ends program execution
		System.exit(0);
	}
	
	/**
	 * 
	 * @param base
	 * @param number1
	 * @param number2
	 * @param sum
	 * 
	 * @precondition: all calculations are completed and the implicit parameters are final
	 * 
	 * @postcondition: parameters are printed out to the Text User Interface running the program
	 * 				   in their correct base
	 */
	public static void output(int base, int number1, int number2, int sum) {
		System.out.println();
		System.out.println("The base of the numbers to add is " + base);
		System.out.println("The first number is " + Integer.toString(number1,base));
		System.out.println("The second number is " + Integer.toString(number2,base));
		System.out.println("The sum is: " + Integer.toString(sum,base));
	}
	
	/**
	 * 
	 * @param number1
	 * @param number2
	 * @param repeat
	 * @returns the sum of [number1] and [number2] multiplied by [repeat]
	 */
	public static int getSum(int number1, int number2, int repeat) {
		
		// the following calculation is equivalent to going 0 up to [repeat] in a 
		// for loop and adding the numbers to sum every loop, but this way is more efficient
		return (number1 + number2) * repeat;
	}
	
	/**
	 * 
	 * @param msg
	 * @postcondition: Error message is printed to terminal/console and program execution is terminated
	 */
	
	public static void printErrorMessage(String msg) {
		System.out.println("Program quit with the error message: " + msg);
		System.exit(0);
	}
}
