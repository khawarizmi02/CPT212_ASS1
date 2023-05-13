  // Radix Sort in Java Programming

import java.util.Arrays;

class Main {

    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;
            System.out.println(Arrays.toString(count));

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;
            System.out.println(Arrays.toString(count));

        // Calculate cumulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
            System.out.println(Arrays.toString(count));

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }
            System.out.println(Arrays.toString(count));

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }
    // Function to get the largest element from an array
    int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // Main function to implement radix sort
    void radixSort(int array[], int size) throws InterruptedException {
        // Get maximum element
        int max = getMax(array, size);

        System.out.println("Max value: ");
        System.out.println(max);
        int index = 1;
        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(array, size, place);

            System.out.println("sorted Array Order for index of " + index + ":" );
            System.out.println(Arrays.toString(array));
            Thread.sleep(2000);
            index++;
        }
    }

    // Driver code
    public static void main(String args[]) throws InterruptedException {

        int[] data = { 275, 87, 426, 061, 409, 170, 677, 503 };
//        int[] data = { 121, 432, 564, 23, 1, 45, 788 };
        int size = data.length;
        System.out.println("current Array Order: ");

        System.out.println(Arrays.toString(data));
        Thread.sleep(2000);
        Main rs = new Main();
        rs.radixSort(data, size);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
