https://leetcode.com/problems/find-peak-element/description/

#### Approach-1 Using Linear Search

* The array can be traversed and the element whose neighbors are less than that element can be returned.

#### Approach-2 Using Binary Search

1. check if the middle element is the peak element or not. 
2. If the middle element is not the peak element, then check if the element on the right side is greater than the middle element then there is always a peak element on the right side. 
3. If the element on the left side is greater than the middle element then there is always a peak element on the left side. 

**Note** that both left and right sides might have peak elements, we just we need to return any peak element. So we can safely either go to left or right

```java
class Solution {
    public int findPeakElement(int[] nums) {

        int len = nums.length;

        int end = len - 1;
        int start = 0;
        int mid = 0;

        while (start <= end) {

            mid = start + (end - start) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == len - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return mid;
    }
}
```