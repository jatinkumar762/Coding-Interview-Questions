https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

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

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };

        result[0] = leftIndex(nums, 0, nums.length - 1, target);
        result[1] = rightIndex(nums, 0, nums.length - 1, target);

        return result;
    }
}
```