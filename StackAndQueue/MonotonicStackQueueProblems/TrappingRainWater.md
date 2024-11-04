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

### Approach-2  Single Traversal

```java
class Solution {
    public int trap(int[] arr) {

        int n = arr.length;

        int left = 0, right = n - 1, sum = 0;

        int leftMax = arr[0], rightMax = arr[right];

        while (left < right) {

            if (leftMax <= rightMax) {

                sum += leftMax - arr[left];

                left++;

                leftMax = arr[left] > leftMax ? arr[left] : leftMax;

            } else {

                sum += rightMax - arr[right];

                right--;

                rightMax = arr[right] > rightMax ? arr[right] : rightMax;
            }

        }

        return sum;
    }
}
```