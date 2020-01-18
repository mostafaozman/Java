/*
 * By: Mostafa Osman
 * 12/14/18
 * This program lets you choose between multiple inputs and sorts the numbers through 
 *different algorithms, these are bubble sort, selection sort, and table sort 
 */




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sort {

	Scanner consoleInput = new Scanner(System.in);
	String input;
	Scanner fileInput;
	int[] inputArray;
	long startTime; 
	
	public Sort() 
	{
		// Prints to the console so user can decide which input and which sorting method
		System.out.println("Ender a number for the input file");
		System.out.println("1: input1.txt  2: input2.txt  3: input3.txt  4: input4.txt");
		input = consoleInput.nextLine();
		if (input.length() !=1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4') 
		{
			System.out.println("Enter 1, 2, 3, or 4");
			while (input.length() !=1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4')
			{
				input = consoleInput.nextLine();
			}
		}
		// Creates a file with sorted array 
		try
		{
			fileInput = new Scanner(new File("input" + input.charAt(0) + ".txt"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}
		String infile = fileInput.nextLine();
		String[] inputStringArray = infile.split(",");
		inputArray = new int[inputStringArray.length];
		for (int i = 0; i < inputStringArray.length; i++) 
		{
			inputArray[i] = Integer.parseInt(inputStringArray[i]);
			System.out.println(inputArray[i]);
		}
		// askes for type of sort
		System.out.println("Ender a number for sort you want to use.");
		System.out.println("1: Bubble  2: Selection  3: Table   4: Quick ");
		input = consoleInput.nextLine();
		if (input.length() !=1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4') 
		{
			System.out.println("Enter 1, 2, 3, or 4.");
			while (input.length() !=1 && input.charAt(0) != '1' && input.charAt(0) != '2' && input.charAt(0) != '3' && input.charAt(0) != '4') 
			{
				input = consoleInput.nextLine();
			
			}
		}
		// ties each sort to a number input
		startTime = System.currentTimeMillis();
		if (input.equals("1"))
		{
			inputArray = bubbleSort(inputArray);
			
		}
		if (input.equals("2"))
		{
			inputArray = selectionSort(inputArray);
			
		}
		if (input.equals("3"))
		{
			inputArray = tableSort(inputArray);
			
		}
		if (input.equals("4"))
		{
			inputArray = quickSort(inputArray);
			
		}
		// Times how long it takes to sort the input 
	    long totalTime = System.currentTimeMillis() - startTime; 
	    System.out.println("Total time: 0" + totalTime);
	    PrintWriter pw; 
	    try 
	    {
		    pw = new PrintWriter(new FileWriter(new File("output.txt")));
		    String output = ""; 
		    
			for (int i = 0; i < inputStringArray.length; i++)
			{
				output += inputArray[i] + ","; 
			}
		    
			output += "\nTotal Time:" + totalTime; 
			pw.write(output); 		
			pw.close(); 
		
			System.out.println(output);
	    } 
	    
	    catch (IOException ex) 
	    {
			ex.printStackTrace();
			System.exit(0);
		}
	}
	
	// Compare each pair of numbers and move the larger to the right
	int[] bubbleSort(int[] array)
	{
		for (int j = 0; j < array.length; j++)
		{
			for (int i = 0; i < array.length - 1; i++)
			{    // If the one on the left is larger
				if (array[i] > array[i + 1])
				{
					//Swap it!
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
		return array;
	}
	// Find the smallest and move it to the front  
	int[] selectionSort(int array[])
	{
		for (int j = 0; j < array.length; j++)
		{
			int smallestNumber = array[j]; 
			int smallestIndex = j; 
			for (int i = j; i < array.length ; i++)
			{
				if (array[i] < smallestNumber)
				{
				smallestNumber = array[i]; 
				smallestIndex = i;
				}
			}
		
			int temp = array[smallestIndex];
			array[smallestIndex] = array[j];
			array[j] = temp; 
		
		}
		
		return array; 
	}
	//Tally how often you see a number, and print out that number of times
	int[] tableSort(int[] array)
	{
		int[] tally = new int[1001]; 
		for (int i = 0; i < array.length; i++)
		{
			tally[array[i]]++;
		}
		
		int count = 0;
		// i keep track of the actual number
		for (int i = 0; i < tally.length; i++)
		{
			// j keeps track of how many times we've seen the number
			for (int j = 0; j < tally[i]; j++)
			{
				array[count] =i;
				count++; 
			}
		}
		
		return array; 
	}
	
	//Quick Sort 
	int [] quickSort(int[] array)
	{
		
		
		
		
		
		return array; 
	}
	
	public static void main(String[] args) {
		new Sort ();
	}

}



