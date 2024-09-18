https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

```java
class Solution {

    int rightIndex(int[] nums, int low, int high, int target) {

        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target && (mid == high || nums[mid + 1] > target)) {
                return mid;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                // nums[mid]<=target
                low = mid + 1;
            }
        }

        return -1;
    }

    int leftIndex(int[] nums, int low, int high, int target) {

        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
                return mid;
            }

            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                // nums[mid]<target
                low = mid + 1;
            }
        }

        return -1;
    }

    int count(int[] arr, int n, int x) {
        //find left occurence
        //find right occurence
        //count = right-left+1

        int rightIndex = rightIndex(arr, 0, n - 1, x);

        //check element exist in array
        if (rightIndex == -1) {
            return 0;
        }

        int leftIndex = leftIndex(arr, 0, n - 1, x);

        return rightIndex - leftIndex + 1;
    }
}
```