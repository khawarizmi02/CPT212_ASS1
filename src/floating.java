// modified code from Radix.java

import java.io.*;
import java.util.*;
import java.util.Random;
import java.math.BigDecimal;
import java.util.Arrays;

public class floating {

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	public int radixsort(float arr[], int n, int count_operator)
	{
    count_operator += 3;

    // Create a temporary long datatype array
    long [] arr_long = new long [n];
    count_operator += 1;

    // const number to time all element with it
    float num = (float) Math.pow(10,7);
    count_operator += 1;

    String string_num = Float.toString(num);
    count_operator += 1;

    String temp_value;
    BigDecimal decimal_arr;
    BigDecimal decimal_num = new BigDecimal(string_num);
    count_operator += 1;

    // Change all float value inside of the array to whole number
    count_operator += 1;
    for (int i = 0; i < n; i++){
      count_operator += 3;

      temp_value = Float.toString(arr[i]);
      decimal_arr = new BigDecimal(temp_value);
      count_operator += 4;

      arr_long[i] = decimal_arr.multiply(decimal_num).longValue();
      count_operator += 4;
    }

		// Find the maximum number to know number of digits
		long m = getMax(arr_long, n, count_operator);
    count_operator += 2;

    // Max value will change to long number
    // long c = decimal_num.multiply(decimal_max).longValue();
    // System.out.println("value of long c: " + c);
    // count_operator += 2;

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
    count_operator += 1;
		for (long exp = 1; m / exp > 0; exp *= 10){
      count_operator += 4;
      count_operator = countSort(arr_long, n, exp, count_operator);
    }

    // change back all sorted number into float number
    count_operator += 1;
    for (int i = 0; i < n; i++){
      count_operator += 3;

      temp_value = Float.toString(arr_long[i]);
      decimal_arr = new BigDecimal(temp_value);
      count_operator += 5;

      arr[i] = decimal_arr.divide(decimal_num).floatValue();
      count_operator += 2;
    }

    // Print out the result of the operator counter
    System.out.println("Operator counter: " + count_operator );
    System.out.println();

    return count_operator;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static int countSort(long arr_long[], int n, long exp, int count_operator)
	{
    // System.out.println("We are in the countSort function: \n");
		long output[] = new long[n]; // output array
		int i;
		int count[] = new int[10];
    // store value 0 to all indexes of count array
		Arrays.fill(count, 0);
    count_operator += 4;

		// Store count of occurrences in count[]
    count_operator += 1;
		for (i = 0; i < n; i++){
      count_operator += 3;
      // count[((long)arr_long[i] / exp) % 10]++;
      count[(int) Math.floor((long)arr_long[i] / exp) % 10]++;
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
			output[count[(int) Math.floor((long)arr_long[i] / exp) % 10] - 1] = arr_long[i];
      count_operator += 6;
			count[(int) Math.floor((long)arr_long[i] / exp) % 10]--;
      count_operator += 5;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current digit
    count_operator += 1;
		for (i = 0; i < n; i++){
      count_operator += 3;
			arr_long[i] = output[i];
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

	// A utility function to get maximum value in arr_long[]
	static long getMax(long arr_long[], int n, int count_operator)
	{
		long mx = arr_long[0];
    count_operator =+ 3;
		for (int i = 1; i < n; i++){
      count_operator += 3;
			if (arr_long[i] > mx){
        count_operator += 3;
				mx = arr_long[i];
      }
    }
		return mx;
	}
}


