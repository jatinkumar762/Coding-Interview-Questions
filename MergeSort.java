import java.util.*;
import java.io.*;

class MergeSort {
    int[] arr;
    int size;

    // Constructor to initialize the array with the given size
    MergeSort(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    // Method to merge two subarrays of arr[]
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
    void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of the first subarray
        int n2 = right - mid;    // Size of the second subarray

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];

        // Merge the temporary arrays back into arr[]
        int i = 0; // Initial index of the first subarray
        int j = 0; // Initial index of the second subarray
        int k = left; // Initial index of the merged subarray

        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // Main function to sort the array using merge sort
    void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort the first and second halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter array size:");
        int size = Integer.parseInt(br.readLine().trim());

        MergeSort ms = new MergeSort(size);

        System.out.println("Enter array elements:");
        String[] str = br.readLine().trim().split(" ");

        for (int i = 0; i < size; i++) {
            ms.arr[i] = Integer.parseInt(str[i]);
        }

        ms.sort(ms.arr, 0, size - 1);

        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int i = 0; i < size; i++) {
            System.out.println(ms.arr[i]);
        }
    }
}
