https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1

**Optimized way to writing Binary Search**

```java
public class CeilInSortedArray {
    public static Integer findCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer ceil = null; // Use Integer to allow for null value

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Found exact match
            } else if (arr[mid] < target) {
                low = mid + 1; // Search in right half
            } else {
                ceil = arr[mid]; // Update ceil
                high = mid - 1; // Search in left half
            }
        }

        return ceil; // Returns null if no ceil is found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12};
        int target = 9;
        Integer ceil = findCeil(arr, target);
        
        if (ceil != null) {
            System.out.println("Ceil of " + target + " is: " + ceil);
        } else {
            System.out.println("No ceil found for " + target);
        }
    }
}
```

#### Approach-1 Sort + Binary Search - O(NLogN) + 2 * O(LogN)

&rarr; in above gfg problem, given array is not sorted

```java
class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        
       Arrays.sort(arr);
       
       int c = getCeil(x, arr);
       int f = getFloor(x, arr);
       
       return new int[]{f,c};
    }
    
    private int getCeil(int target, int[] nums){
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        //imp condition to check
        if(nums[end]<target){
            return -1;
        }
        
        if(nums[start]>=target){
            return nums[start];
        }

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            }
            
            
            //If target lies between mid+1 and mid
            if(mid+1<=end && nums[mid] < target && nums[mid+1] > target){
                return nums[mid+1];
            }
            
            // If target lies between mid-1 and mid
            if(mid-1>=0 && nums[mid] > target && nums[mid-1] < target){
                return nums[mid];
            }
            

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
    
    private int getFloor(int target, int[] nums){
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        //imp condition to check
        if(nums[end]<=target){
            return nums[end];
        }
        
        if(nums[start]>target){
            return -1;
        }

        while (start <= end) {

            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            }
            
            
            //If target lies between mid+1 and mid
            if(mid+1<=end && nums[mid] <= target && nums[mid+1] > target){
                return nums[mid];
            }
            
            // If target lies between mid-1 and mid
            if(mid-1>=0 && nums[mid] > target && nums[mid-1] <= target){
                return nums[mid-1];
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

#### Approach-2 linear Search - O(N) [given array is unsorted]