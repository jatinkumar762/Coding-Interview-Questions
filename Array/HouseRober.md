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

#### Method-2: Iterative + 2 variables (bottom-up)

```java
/* the order is: prev2, prev1, num  */
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = tmp;
    }
    return prev1;
}
```

#### Editorial

* [From good to great. How to approach most of DP problems.](https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.)