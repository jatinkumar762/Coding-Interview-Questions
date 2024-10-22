https://leetcode.com/problems/kth-missing-positive-number/description/


### Approach-1 linear $O(N)$ 

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