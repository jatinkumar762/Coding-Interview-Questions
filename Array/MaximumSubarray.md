[Problem](https://leetcode.com/problems/maximum-subarray/)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        
         // Your code here
        int maxSum = nums[0];
        int sum = maxSum;
        
        for(int i=1;i<nums.length;i++){
            if(sum+nums[i]<nums[i])
                sum = nums[i];
            else
                sum += nums[i];
            
            if(maxSum<sum)
                maxSum = sum;
        }
        return maxSum;
        
    }
}
```