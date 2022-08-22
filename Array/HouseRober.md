[Problem](https://leetcode.com/problems/house-robber/)

```java
class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 0) return 0;
        
        if (nums.length == 1) return nums[0];
        
        int[] memo = new int[nums.length + 1];
        memo[0] = nums[0];
        memo[1] = (nums[0]>nums[1])?nums[0]:nums[1];
        for (int i = 2; i < nums.length; i++) {
            int val = nums[i];
            memo[i] = Math.max(memo[i-1], memo[i-2] + val);
        }
        return memo[nums.length-1];
        
        /*
            nums    ->  5 3 4 5
            arr     ->  5 5 9 10
        */ 
    }
}
```