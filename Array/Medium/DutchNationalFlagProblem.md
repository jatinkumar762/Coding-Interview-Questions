https://leetcode.com/problems/sort-colors/description/

#### Approach-1 Count of 0, 1 and 2

* one pass - will use 3 different variables to store count of 0, 1, 2
* second pass - based on the count, will put first 0, then 1 and after this 2 in array

#### Approach-2 In Single pass

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