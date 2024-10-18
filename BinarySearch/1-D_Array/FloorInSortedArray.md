https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

* the floor of x is the largest element in the array smaller than or equal to x

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


**Another approach using Binary Search**

```java
public class FloorInSortedArray {
    public static Integer findFloor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        Integer floor = null; // Use Integer to allow for null value

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Found exact match
            } else if (arr[mid] < target) {
                floor = arr[mid]; // Update floor
                low = mid + 1; // Search in right half
            } else {
                high = mid - 1; // Search in left half
            }
        }

        return floor; // Returns null if no floor is found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12};
        int target = 9;
        Integer floor = findFloor(arr, target);
        
        if (floor != null) {
            System.out.println("Floor of " + target + " is: " + floor);
        } else {
            System.out.println("No floor found for " + target);
        }
    }
}
```