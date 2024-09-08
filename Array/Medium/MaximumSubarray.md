[Problem](https://leetcode.com/problems/maximum-subarray/)

* Kadane's Algorithm is a well-known algorithm used to solve the "Maximum Subarray Sum Problem"
* the goal is to find the contiguous subarray within a one-dimensional array of numbers that has the largest sum.

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int left = 0, right = 0;
        int n = nums.length;
        int sum = 0, maxSum = 0;
        for (; right < n; right++) {

            if (right == 0) {
                sum = nums[right];
                maxSum = sum;
                continue;
            }

            if (sum + nums[right] < nums[right]) {
                left = right;
                sum = nums[right];
            } else {
                sum += nums[right];
            }

            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
```

**Note**

* not asked range, so we can remove left pointer

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
