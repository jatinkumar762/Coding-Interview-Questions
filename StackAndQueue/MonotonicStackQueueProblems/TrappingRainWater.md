https://leetcode.com/problems/trapping-rain-water/description/

### Approach-1 

* two traversal

```java
class Solution {
    public int trap(int[] arr) {

        int n = arr.length;

        int[] leftMax = new int[n];

        int max = arr[0];
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
            leftMax[i] = max;
        }

        int rightMax = arr[n - 1];

        int res = 0, maxLRHeight;
        for (int i = n - 2; i >= 1; i--) {

            if (rightMax > arr[i]) {
                maxLRHeight = leftMax[i] < rightMax ? leftMax[i] : rightMax;
                res += maxLRHeight - arr[i];
            } else {
                rightMax = arr[i];
            }
        }

        return res;
    }
}
```