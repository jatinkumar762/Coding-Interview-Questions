https://leetcode.com/problems/reverse-pairs/description/

#### Approach-1 

* if any number is -ve, then its double will more negative means less

* this condition will give wrong answer ~~(nums[j] <= (Integer.MAX_VALUE/2) && nums[i] > (2 * nums[j]))~~


```java
class Solution {
    public int reversePairs(int[] nums) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[j] < 0 && nums[i]>=nums[j]) || (nums[i]/2.0 > nums[j])){
                    count += 1;
                }
            }
        }

        return count;
    }
}
```

#### Approach-2 - Optimized

    $i$             $j$
[6, 13, 21, 25]   [1, 2, 3, 4, 4, 5, 9, 11, 13]

```java
class Solution {

    // Method to merge two subarrays of arr[]
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
    void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of the first subarray
        int n2 = right - mid; // Size of the second subarray

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
            if (L[i] <= R[j]) {
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

    int countReversePairs(int[] arr, int left, int mid, int right) {

        int count = 0;
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && arr[i]/2.0 > arr[j]){
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    // Main function to sort the array using merge sort
    int sort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + ((right-left)/2);

            // Sort the first and second halves
            count += sort(arr, left, mid);
            count += sort(arr, mid + 1, right);

            count += countReversePairs(arr, left, mid, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
        return count;
    }

    public int reversePairs(int[] nums) {

        int len = nums.length;
        return sort(nums, 0, len - 1);
    }
}
```

**Note:**

* this while loop condition will also work (arr[i]/2.0 > arr[j])
* but, this (nums[j] <= (Integer.MAX_VALUE/2) && nums[i] > (2 * nums[j])) will give wrong answer

```java
int countReversePairs(int[] arr, int left, int mid, int right) {
    int count = 0;
    int j = mid + 1;
    for (int i = left; i <= mid; i++) {
        while (j <= right && ((arr[j] < 0 && arr[i]>=arr[j]) || (arr[i]/2.0 > arr[j]))) {
            j++;
        }
        count += (j - (mid + 1));
    }

    return count;
}
```