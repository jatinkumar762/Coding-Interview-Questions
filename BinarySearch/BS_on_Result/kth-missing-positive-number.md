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