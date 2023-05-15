// Radix sort Java implementation

import java.io.*;
import java.util.*;
import java.util.Random;

class Radix {

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	static void radixsort(int arr[], int n, int count_operator)
	{
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp, count_operator);

    // Print out the result of the operator counter
    System.out.println("Operator counter: " + count_operator + " \n");
	}

 
	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static void countSort(int arr[], int n, int exp, int count_operator)
	{
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
    count_operator += 4;

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++){
			count[(arr[i] / exp) % 10]++;
    }

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current
		// digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
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
	static void print(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
      System.out.println(" \n");
	}

	// Main driver method
	public static void main(String[] args)
	{
    
    int n;
    int count_operator = 0; // Operator counter
    int [] array; // Define an array
    Random rand = new Random(); // Define random function

    array = new int[1];
    array[0] = rand.nextInt(99999) + 1;
    System.out.println(array[0]);
    n = array.length;
    radixsort(array, n, count_operator);
    print(array, n);
    
    for (int i = 5; i <= 15; i = i + 5){
        array = new int[i];
        System.out.println("Create an array with the size of " + i + " : \n");
        for (int k = 0; k < array.length; k++) {
            array[k] = rand.nextInt(99999) + 1; // Input a random number between 1 to 99999
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " "); // Print all list of random number
        }
        System.out.println(" \n");

        // Function call to the radixSort
        n = array.length; // Get the length of the array
        count_operator = 0; // Set the operator counter to 0
        radixsort(array, n, count_operator); 
        System.out.println("Result of the radix sort: \n");
        print(array, n);
    }
	}
}


