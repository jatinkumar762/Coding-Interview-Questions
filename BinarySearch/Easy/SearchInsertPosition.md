https://leetcode.com/problems/search-insert-position/description/

```java
class Solution {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2; // if dont initialize will get compile time error - can be uninitialized

        if (target > nums[end]) {
            return end + 1;
        }

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[mid] > target ? mid : mid + 1;

    }
}
```