https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

* not necessarily with distinct values

first step is identifying the sorted half

arr[] &rarr; [3, 1, 2, 3, 3, 3, 3]

index &rarr;  0&nbsp;&nbsp;1&nbsp;&nbsp;2&nbsp;&nbsp;3&nbsp;&nbsp;4&nbsp;&nbsp;5&nbsp;&nbsp;6

arr[low] = arr[mid] = arr[high]

trim the search space

low = low + 1;   high = high - 1;


```java
class Solution {
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                // unable to decide which part of arrary is sorted
                // trim the search space
                left = left + 1;
                right = right - 1;
                continue;
            }

            //one part will be sorted

            if (nums[mid] <= nums[right]) {
                // right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    //target==mid already checked
                    // traget present in sorted block
                    left = mid + 1;
                } else {
                    // traget present in non-sorted block
                    right = mid - 1;
                }
            } else {
                
                //left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // traget present in sorted block
                   right = mid - 1;
                } else {
                    // traget present in non-sorted block
                    left = mid + 1;
                }
            }
        }

        return false;
    }
}
```


