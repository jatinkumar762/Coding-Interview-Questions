[Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

```java
class Solution {
    public int search(int[] nums, int target) 
    {
        if(nums.length==0)
            return -1;
            
        int left=0,low,mid;
        int right=nums.length-1;
        
        
        while(left<right)
        {
            mid=(left+right)/2;
            if(nums[mid]<nums[right])
                right=mid;
            else
                left=mid+1;
        }
        
        // left==hi is the index of the smallest value and also the number of places rotated.
        
        low=left;
        left=0;right=nums.length-1;
         
        if(nums[low]<target && nums[right]>=target)
            left=low;
        else
            right=low;
        
        while(left<=right)
        {
            if(nums[left]==target)
                return left;
            else
            if(nums[right]==target)
                return right;
            else
            {
                mid=left+(right-left)/2;
                if(nums[mid]==target) return mid;
                if(nums[mid]<target)
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}
```