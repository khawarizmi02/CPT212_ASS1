// Radix sort Java implementation

import java.io.*;
import java.util.*;
import java.util.Random;

public class Radix {

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	public int radixsort(int arr[], int n, int count_operator)
	{
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);
    count_operator += 4;

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
    count_operator += 1;
		for (int exp = 1; m / exp > 0; exp *= 10){
      count_operator += 3;
			count_operator = countSort(arr, n, exp, count_operator);
    }

    // Print out the result of the operator counter
    System.out.println("Operator counter: " + count_operator + " \n");

    // return count_operator to the dataset
    return count_operator;
	}

 
	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static int countSort(int arr[], int n, int exp, int count_operator)
	{
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
    count_operator += 4;

		// Store count of occurrences in count[]
    count_operator += 1;// Assignment i= 0
		for (i = 0; i < n; i++){
			count[(arr[i] / exp) % 10]++;
      count_operator += 3;
      count_operator += 4;
    }

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
    count_operator += 1;
		for (i = 1; i < 10; i++){
			count[i] += count[i - 1];
      count_operator += 3;
      count_operator += 3;
    }

		// Build the output array
    count_operator += 1;
		for (i = n - 1; i >= 0; i--) {
      count_operator += 3;
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count_operator += 5;
			count[(arr[i] / exp) % 10]--;
      count_operator += 4;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current
		// digit
    count_operator += 1;
		for (i = 0; i < n; i++){
      count_operator += 3;
			arr[i] = output[i];
      count_operator += 1;
    }


    return count_operator;
	}

	// A utility function to get maximum value in arr[]
	static int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	// A utility function to print an array
	public void print(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
      System.out.println(" \n");
	}

	// Main driver method
	// public static void main(String[] args)
	// {
 //    
 //    int n;
 //    int count_operator = 0; // Operator counter
 //    int [] array; // Define an array
 //    Random rand = new Random(); // Define random function
	//
 //    int max_array = 10;
 //    int [] dataset = new int[max_array];
	//
 //    System.out.println("******************************************************************************************");
 //    array = new int[1];
 //    n = array.length;
 //    array[0] = rand.nextInt(99999) + 1;
 //    System.out.println("Array: " + array[0] + " \n");
 //    dataset [0] = radixsort(array, n, count_operator);
 //    System.out.println("Result of the radix sort: ");
 //    print(array, n);
 //    System.out.println("******************************************************************************************");
	//
 //    for (int i = 2; i <= max_array; i = i + 1){
 //        array = new int[i];
 //        System.out.println("******************************************************************************************");
 //        System.out.println("Create an array with the size of " + i + " : ");
 //        for (int k = 0; k < array.length; k++) {
 //            array[k] = rand.nextInt(99999) + 1; // Input a random number between 1 to 99999
 //        }
 //        for (int j = 0; j < array.length; j++) {
 //            System.out.print(array[j] + " "); // Print all list of random number
 //        }
 //        System.out.println(" \n");
	//
 //        // Function call to the radixSort
 //        n = array.length; // Get the length of the array
 //        count_operator = 0; // Set the operator counter to 0
 //        dataset [i - 1] = radixsort(array, n, count_operator); 
 //        System.out.println("Result of the radix sort: ");
 //        print(array, n);
 //        System.out.println("******************************************************************************************");
 //    }
	//
 //    // print the dataset
 //    int row;
 //    System.out.println("<------------------->");
 //    for (int i = 0; i < dataset.length; i++){
 //      row = i + 1;
 //      System.out.println(row + " || " + dataset[i]);
 //    }
 //    System.out.println("<------------------->");
	// }
}


