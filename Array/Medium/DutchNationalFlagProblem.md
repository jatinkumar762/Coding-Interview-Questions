https://leetcode.com/problems/sort-colors/description/

#### Approach-1 Count of 0, 1 and 2

* one pass - will use 3 different variables to store count of 0, 1, 2
* second pass - based on the count, will put first 0, then 1 and after this 2 in array

#### Approach-2 In Single pass

* Dutch Partitioning Problem, is a classic algorithmic problem that involves sorting an array with three distinct values. 
* The Dutch National Flag Problem can be solved efficiently using a single pass through the array with a three-way partitioning technique.

**Approach**

1. Initialization: Define three pointers:
    * low: This pointer tracks the boundary for the 0s.
    * mid: This pointer scans through the array.
    * high: This pointer tracks the boundary for the 2s.  

2. Processing:
    * Start with low at the beginning of the array, mid also at the beginning, and high at the end of the array.
    * Iterate through the array with the mid pointer:
        * If the element at mid is 0, swap it with the element at low and increment both low and mid.
        * If the element at mid is 1, just move the mid pointer forward.
        * If the element at mid is 2, swap it with the element at high and decrement high. Do not move mid forward in this case because the element swapped from high needs to be processed.

3. Termination:
    * Continue this process until mid exceeds high.

```java
class Solution {
    
    public void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
    
    public void sortColors(int[] nums) {
        int low = 0, mid=0, high=nums.length-1;
        
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, low, mid);
                low+=1; //will point to first index of 1 after re-arrange
                mid+=1;
            } else if(nums[mid]==1){
                mid+=1;
            } else if(nums[mid]==2){
                swap(nums, mid, high);
                high-=1;
            }
            
        }
    }
}
```