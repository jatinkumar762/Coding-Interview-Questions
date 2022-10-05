[Sort Colors](https://leetcode.com/problems/sort-colors/)

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
                low+=1;
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

#### Editorial
* [https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/](https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/)