https://leetcode.com/problems/search-in-rotated-sorted-array/description/

first find pivot point 

Example:

arr     &rarr; [5, 6, 0, 1, 2, 3, 4]

ind     &rarr;  0  1  2  3  4  5  6

mid = 3

after this low -> 0 and high = 2

step 2:

arr     &rarr; [5, 6, 0]

ind     &rarr;  0  1  2



```java
class Solution {

    public int search(int[] nums, int target) {

        int pivot = findMin(nums);

        if (nums[pivot] == target) {
            return pivot;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        if (target > nums[end]) {
            //means it exist in left side of pivot
            end = pivot-1;
        } else {
            //means it exist in right side of pivot
            start = pivot;
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

        return -1;

    }

    private int findMin(int[] arr) {
        // complete the function here
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {

            // The current subarray is already sorted,
            // the minimum is at the low index
            if (arr[left] <= arr[right]) {
                return left;
            }

            mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // The right half is not sorted. So
                // the minimum element must be in the
                // right half.
                left = mid + 1;
            } else {

                // The right half is sorted. Note that in
                // this case, we do not change high to mid - 1
                // but keep it to mid. The mid element
                // itself can be the smallest
                right = mid;
            }
        }

        return left;
    }
}
```