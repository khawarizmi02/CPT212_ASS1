//
//   // Radix Sort in Java Programming
//
// import java.util.Arrays;
//
// class floating {
//
//     // Using counting sort to sort the elements in the basis of significant places
//     void countingSort(float array[], int size, float place) {
//         float[] output = new float[size + 1];
//         float max = array[0];
//         for (int i = 1; i < size; i++) {
//             if (array[i] > max)
//                 max = array[i];
//         }
//         int[] count = new int[max + 1];
//
//         for (int i = 0; i < max; ++i)
//             count[i] = 0;
//
//         // Calculate count of elements
//         for (int i = 0; i < size; i++)
//             count[(array[i] / place) % 10]++;
//
//         // Calculate cumulative count
//         for (int i = 1; i < 10; i++)
//             count[i] += count[i - 1];
//
//         // Place the elements in sorted order
//         for (int i = size - 1; i >= 0; i--) {
//             output[count[(array[i] / place) % 10] - 1] = array[i];
//             count[(array[i] / place) % 10]--;
//         }
//
//         for (int i = 0; i < size; i++)
//             array[i] = output[i];
//     }
//
//     // Function to get the largest element from an array
//     int getMax(float array[], int n) {
//         float max = array[0];
//         for (int i = 1; i < n; i++)
//             if (array[i] > max)
//                 max = array[i];
//         return max;
//     }
//
//     // Main function to implement radix sort
//     void radixSort(float array[], int size) throws InterruptedException {
//         // Get maximum element
//         float max = getMax(array, size);
//
//         System.out.println("Max value: ");
//         System.out.println(max);
//         int index = 1;
//         // Apply counting sort to sort elements based on place value.
//         for (float place = 1.0; max / place > 0; place *= 10) {
//             countingSort(array, size, place);
//
//             System.out.println("sorted Array Order for index of " + index + ":" );
//             System.out.println(Arrays.toString(array));
//             Thread.sleep(2000);
//             index++;
//         }
//     }
//
//     // Driver code
//     public static void main(String args[]) throws InterruptedException {
//
//         // float[] data = { 275, 87, 426, 061, 409, 170, 677, 503 };
//         float[] data = { 1.2, 1.3, 0.12, 2.12343, 2.543, 0.0012, 0.12, 1.25 };
// //        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
//         int size = data.length;
//         System.out.println("current Array Order: ");
//
//         System.out.println(Arrays.toString(data));
//         Thread.sleep(2000);
//         floating rs = new floating();
//         rs.radixSort(data, size);
//         System.out.println("Sorted Array in Ascending Order: ");
//         System.out.println(Arrays.toString(data));
//     }
// }

import java.lang.System;
import java.util.Arrays;

 class floating {

     void countingSort(double exp, double array[])
    {
        int[] count = new int[10];
        double[] output = new double[array.length];

        for (double value : array) {
            count[(int) ((value / exp) % 10)]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(int) ((array[i] / exp) % 10)] - 1] = array[i];
            count[(int) ((array[i] / exp) % 10)]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }

    // Function to get the largest element from an array
    double getMax(double array[], int n) {
        double max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    void radixSort(double array[], int size) {
        double max = getMax(array , size);
        for (double exp = 1; max / exp > 0; exp *= 10) {
            countingSort(exp, array);
        }
    }

     public static void main(String[] args) {
       double data[] = { 170, 45.2, 75.69, 90.68, 802, 24, 2, 66 };
       int size = data.length;

       System.out.println("Unsorted arrray list: ");
       System.out.println(Arrays.toString(data));

       floating rs = new floating();

       rs.radixSort(data, size);
 
       System.out.println("Sorted arrray list: ");
       System.out.println(Arrays.toString(data));
    }
}

