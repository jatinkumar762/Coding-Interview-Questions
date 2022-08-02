[Problem](https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1)

#### Methods
* Sorting - O(NlogN)
* MinHeap - O(n + kLogn)
* MaxHeap -  O(k + (n-k)*Logk)
* QuickSort - 
* Randomized QuickSort

```java
class Solution{
    public static int kthSmallest(int arr[], int l, int r, int k) 
    { 
        // If k is smaller than number of elements in array 
        if (k > 0 && k <= r - l + 1) 
        { 
            // Partition the array around a random element and 
            // get position of pivot element in sorted array 
            int pos = randomPartition(arr, l, r); 
 
            // If position is same as k 
            if (pos-l == k-1) 
                return arr[pos]; 
 
            // If position is more, recur for left subarray 
            if (pos-l > k-1) 
                return kthSmallest(arr, l, pos-1, k); 
 
            // Else recur for right subarray 
            return kthSmallest(arr, pos+1, r, k-pos+l-1); 
        } 
 
        // If k is more than number of elements in array 
        return Integer.MAX_VALUE; 
    } 
    
    // Utility method to swap arr[i] and arr[j] 
    static void swap(int arr[], int i, int j) 
    { 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    } 
    
    static int partition(int arr[], int l, int r) 
    { 
        int x = arr[r], i = l; 
        for (int j = l; j < r; j++) 
        { 
            if (arr[j] <= x) 
            { 
                swap(arr, i, j); 
                i++; 
            } 
        } 
        swap(arr, i, r); 
        return i; 
    } 
    
    static int randomPartition(int arr[], int l, int r) 
    { 
        int n = r - l + 1; 
        int pivot = (int)(Math.random() * (n - 1)); 
        swap(arr, l + pivot, r); 
        return partition(arr, l, r); 
    } 
 
}
```

[Editorial](https://www.cdn.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/)
