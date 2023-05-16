import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class main {
  public static void main(String[] args) throws IOException{
    
    int n = 0;
    int count_operator = 0; // Operator counter

    int max_array = 10;
    int [] dataset_radix = new int[max_array];
    int [] dataset_float = new int[max_array];

    CallingRadix(dataset_radix, max_array, n, count_operator);

    CallingFloat(dataset_float, max_array, n, count_operator);

    SaveDataToCSV(dataset_radix, dataset_float, max_array);

  }

  static void SaveDataToCSV (int dataset_radix[], int dataset_float[], int array_size) throws IOException {

    String data_radix, data_float, size;

    // create or open file dataset.csv
    Writer writer = new FileWriter("dataset.csv");
    writer.write(""); // clear all data from the csv file
    writer.write("Size,integer,float"); // header point
    writer.write(" \n"); // new collumn


    // input all the data that have been obtain
    for (int i = 0; i < array_size; i++){
      // set all the data value to String datatype
      // writer cannot pass the other than String datatype
      size = String.valueOf(i+1); 
      data_radix = String.valueOf(dataset_radix[i]);
      data_float =String.valueOf(dataset_float[i]);
      writer.write(size);
      writer.write(",");
      writer.write(data_radix);
      writer.write(",");
      writer.write(data_float);
      writer.write(" \n");
    }

    // Close the writer
    writer.close();

    System.out.println("data successfully added!!!");
  }

  static void CallingFloat(int dataset_float[], int max_array, int n, int count_operator) {

    floating radix_float = new floating();
    Random rand = new Random();
    float [] array; // Define an array

    System.out.println("******************************************************************************************");
    array = new float[1];
    n = array.length;
    array[0] = rand.nextFloat() * 999;
    System.out.println("Array: " + array[0] + " \n");
    dataset_float [0] = radix_float.radixsort(array, n, count_operator);
    System.out.println("Result of the radix sort: ");
    System.out.println("Array: " + array[0] + " \n");

    for (int i = 2; i <= max_array; i = i + 1){
        array = new float[i];
        System.out.println("Create an array with the size of " + i + " : ");
        for (int k = 0; k < array.length; k++) {
            array[k] = rand.nextFloat() * 999; // Input a random number between 1 to 99999
        }
        radix_float.print(array, i);

        // Function call to the radixSort
        n = array.length; // Get the length of the array
        count_operator = 0; // Set the operator counter to 0
        dataset_float [i - 1] = radix_float.radixsort(array, n, count_operator); 
        System.out.println("Result of the radix sort: ");
        radix_float.print(array, i);
    }
    System.out.println("******************************************************************************************");

    // print the dataset
    int row;
    System.out.println("<------------------->");
    for (int i = 0; i < dataset_float.length; i++){
      row = i + 1;
      System.out.println(row + " || " + dataset_float[i]);
    }
    System.out.println("<------------------->");
  }

  static void CallingRadix(int dataset_radix[], int max_array, int n, int count_operator) {

    Radix radix = new Radix();
    Random rand = new Random(); // Define random function
    int [] array; // Define an array

    System.out.println("******************************************************************************************");
    array = new int[1];
    n = array.length;
    array[0] = rand.nextInt(99999) + 1;
    System.out.println("Array: " + array[0] + " \n");
    dataset_radix [0] = radix.radixsort(array, n, count_operator);
    System.out.println("Array: " + array[0] + " \n");

    for (int i = 2; i <= max_array; i = i + 1){
        array = new int[i];
        System.out.println("Create an array with the size of " + i + " : ");
        for (int k = 0; k < array.length; k++) {
            array[k] = rand.nextInt(99999) + 1; // Input a random number between 1 to 99999
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " "); // Print all list of random number
        }

        // Function call to the radixSort
        n = array.length; // Get the length of the array
        count_operator = 0; // Set the operator counter to 0
        dataset_radix [i - 1] = radix.radixsort(array, n, count_operator); 
        System.out.println("Result of the radix sort: ");
        radix.print(array, n);
    }
    System.out.println("******************************************************************************************");
    // print the dataset
    int row;
    System.out.println("<------------------->");
    for (int i = 0; i < dataset_radix.length; i++){
      row = i + 1;
      System.out.println(row + " || " + dataset_radix[i]);
    }
    System.out.println("<------------------->");

  }
}
