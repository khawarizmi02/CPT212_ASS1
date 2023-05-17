// Radix sort Java implementation

import java.io.*;
import java.util.*;

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
    System.out.println("Operator counter: " + count_operator );

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

}


