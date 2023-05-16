// modified code from Radix.java

import java.io.*;
import java.util.*;
import java.util.Random;

public class floating {

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	public int radixsort(float arr[], int n, int count_operator)
	{
    count_operator += 3;

    // const number to time all element with it
    float num = (float) Math.pow(10,7);
    count_operator += 1;

		// Find the maximum number to know number of digits
		float m = getMax(arr, n);
    count_operator += 1;

    // Change all float value inside of the array to whole number
    count_operator += 1;
    for (int i = 0; i < n; i++){
      count_operator += 3;
      arr[i] = arr[i] * num;
      count_operator += 2;
    }

    // Max value will change to int number
    long c = (long) m * (long) num;
    count_operator += 2;

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
    count_operator += 1;
		for (int exp = 1; c / exp > 0; exp *= 10){
      count_operator += 4;
      count_operator = countSort(arr, n, exp, count_operator);
    }

    // change back all sorted number into float number
    count_operator += 1;
    for (int i = 0; i < n; i++){
      count_operator += 3;
      arr[i] = arr[i] / num;
      count_operator += 2;
    }

    return count_operator;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static int countSort(float arr[], int n, int exp, int count_operator)
	{
    // System.out.println("We are in the countSort function: \n");
		float output[] = new float[n]; // output array
		int i;
		int count[] = new int[10];
    // store value 0 to all indexes of count array
		Arrays.fill(count, 0);
    count_operator += 4;

		// Store count of occurrences in count[]
    count_operator += 1;
		for (i = 0; i < n; i++){
      count_operator += 3;
      count[((int)arr[i] / exp) % 10]++;
      count_operator += 5;
    }

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
    count_operator += 1;
		for (i = 1; i < 10; i++){
      count_operator += 3;
			count[i] += count[i - 1];
      count_operator += 3;
    }

		// Build the output array
    count_operator += 1;
		for (i = n - 1; i >= 0; i--) {
      count_operator += 3;
			output[count[((int)arr[i] / exp) % 10] - 1] = arr[i];
      count_operator += 6;
			count[((int)arr[i] / exp) % 10]--;
      count_operator += 5;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
    count_operator += 1;
		for (i = 0; i < n; i++){
      count_operator += 3;
			arr[i] = output[i];
      count_operator += 1;
    }

    return count_operator;
	}

	// A utility function to print an array
	public void print(float arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
      System.out.println();
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
}


