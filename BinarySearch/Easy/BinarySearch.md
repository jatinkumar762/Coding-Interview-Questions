https://leetcode.com/problems/binary-search/description/

```java
class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (nums[start] == target) {
                return start;
            }

            if (nums[end] == target) {
                return end;
            }

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
```