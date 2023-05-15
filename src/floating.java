// modified code from Radix.java

import java.io.*;
import java.util.*;

class floating {

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	static void radixsort(float arr[], int n)
	{
    // const number to time all element with it
    float num = (float) Math.pow(10,7);

		// Find the maximum number to know number of digits
		float m = getMax(arr, n);

    // Change all float value inside of the array to whole number
    for (int i = 0; i < n; i++)
      arr[i] = arr[i] * num;
    // System.out.println(Arrays.toString(arr));


    // Max value will change to int number
    int c = (int) m * (int) num;

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; c / exp > 0; exp *= 10)
			countSort(arr, n, exp);

    // change back all sorted number into float number
    for (int i = 0; i < n; i++)
      arr[i] = arr[i] / num;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static void countSort(float arr[], int n, int exp)
	{
    // System.out.println("We are in the countSort function: \n");
		float output[] = new float[n]; // output array
		int i;
		int count[] = new int[10];
    // store value 0 to all indexes of count array
		Arrays.fill(count, 0);
    // System.out.println(Arrays.toString(count));

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[((int)arr[i] / exp) % 10]++;
    // System.out.println(Arrays.toString(count));

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
    // System.out.println(Arrays.toString(count));

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[((int)arr[i] / exp) % 10] - 1] = arr[i];
			count[((int)arr[i] / exp) % 10]--;
		}
    // System.out.println(Arrays.toString(count));
    // System.out.println(Arrays.toString(output));

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}
    // System.out.println(Arrays.toString(arr));

	// A utility function to print an array
	static void print(float arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
      System.out.println(" \n");
	}

	// A utility function to get maximum value in arr[]
	static float getMax(float arr[], int n)
	{
		float mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	// Main driver method
	public static void main(String[] args)
	{
    float[] arr = {9.1f, 3.387921f, 123.198456f, 12.945678f, 0.521345f, 0.876543f, 56.234567f, 0.612345f, 0.098765f, 0.456789f};
		int n = arr.length;
		print(arr, n);

		// Function Call
		radixsort(arr, n);
		print(arr, n);
	}
}


