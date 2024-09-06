[Problem](https://leetcode.com/problems/rotate-array/)

```java
class Solution {
    public void reverse(int[] nums,int start,int end){
        int tmp;
        while(start<end){
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }    
    }
    
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
          return;
        }
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        
    }
}
```