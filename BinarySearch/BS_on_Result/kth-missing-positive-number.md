https://leetcode.com/problems/kth-missing-positive-number/description/


### Approach-1 linear $O(N)$ - 1ms

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {

        int len = arr.length;

        //arr = [5, 6, 9, 10], k = 4 -> ans = 4  

        // if k = 6, -> ans = 8
        
        // missing -> m-i -> ith missing 
        // m-1 m-2 m-3 m-4         m-5 m-6
        // 1    2   3   4   5   6   7   8   9   10

        for (int i = 0; i < len; i++) {
            if (arr[i] <= k) {
                k++;
            } else {
                return k;
            }
        }

        return k;
    }
}
```

### Approach-2 

```java
public class KthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int current = 1;
        int index = 0;

        while (missingCount < k) {
            if (index < arr.length && arr[index] == current) {
                index++;
            } else {
                missingCount++;
                if (missingCount == k) {
                    return current;
                }
            }
            current++;
        }

        return -1; // This line should never be reached if k is valid
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k)); // Output: 9
    }
}
```

### Approach-3 Binary Search - $O(LogN)$ - 0ms

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {

       int left = 0, right = arr.length - 1;
        
        // Binary search to find the point where missing count reaches k
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Calculate how many positive numbers are missing up to arr[mid]
            int missingCount = arr[mid] - (mid + 1);

            //why mid+1 
            //in correct array
            //at 0th index -> 1, 1st index -> 2, 2nd index -> 3
            
            // If missingCount is less than k, move to the right
            if (missingCount < k) {
                left = mid + 1;
            } else { // Move to the left
                right = mid - 1;
            }
        }

        //after above steps
        //right = left -1

        //missing count on right index < k
        //missing count on left index >=k
        
        // The number of missing numbers up to arr[right]:
        int missingCount = right >= 0 ? arr[right] - (right + 1) : 0;

        //WHY (k - missingCount)? -> bcz till right index we already have missing count
        //remaning missing will be -> (k - missingCount)

        // The k-th missing number will be after the last number in the array + (k - missingCount)
        return (right >= 0 ? arr[right]: 0) + (k - missingCount);
    }

    // [5, 6, 7] k=4
    // after bs -> right = -1 and left = 0
    //
}
```