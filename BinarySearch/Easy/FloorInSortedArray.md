https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

```java
class Solution {

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long nums[], int n, long target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        //imp condition to check
        if(nums[end]<=target){
            return end;
        }
        
        if(nums[start]>target){
            return -1;
        }

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            
            
            //If target lies between mid+1 and mid
            if(mid+1<=end && nums[mid] <= target && nums[mid+1] > target){
                return mid;
            }
            
            // If target lies between mid-1 and mid
            if(mid-1>=0 && nums[mid] > target && nums[mid-1] <= target){
                return mid-1;
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