https://leetcode.com/problems/house-robber/description/

#### Top-Down (Memorization)

```java
class Solution {

    int[] dp;

    private int robHouse(int[] nums, int index) {

        if (index == 0) {
            dp[index] = nums[0];
            return dp[index];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int max = nums[index], rob = Integer.MIN_VALUE;
        for (int i = 1; i <= index; i++) {

            if (i == 1) { //can't pick neighbor
                rob = robHouse(nums, index - i);
            } else {
                rob = nums[index] + robHouse(nums, index - i);
            }
            max = max > rob ? max : rob;
        }

        dp[index] = max;

        return dp[index];
    }

    public int rob(int[] nums) {

        int N = nums.length;

        dp = new int[N];

        Arrays.fill(dp, -1);

        return robHouse(nums, N - 1);
    }
}
```

#### Bottom-Up (Tabulation)

```java
class Solution {

    int[] dp;
    
    public int rob(int[] nums) {

        int N = nums.length;

        if (N == 1) {
            return nums[0];
        } else if (N == 2) {
            return nums[0] < nums[1] ? nums[1] : nums[0];
        }

        dp = new int[N];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < N; i++) {

            int max = dp[i - 1];

            for (int j = 2; j <= i && j <= 3; j++) {
                int tmp = nums[i] + dp[i - j];
                max = max > tmp ? max : tmp;
            }

            dp[i] = max;
        }

        return dp[N - 1];
    }
}
```

---

### Top-Down Approach (Similar to generate subsequence)

```java
class Solution {

    int[] dp;

    private int robHouse(int[] nums, int index) {

        if(index < 0){
            return 0;
        }

        if (index == 0) {
            dp[index] = nums[0];
            return dp[index];
        }

        if (dp[index] != -1) {
            return dp[index];
        }


        int take = nums[index] + robHouse(nums, index-2);

        int notTake = robHouse(nums, index-1);
        
        dp[index] = take > notTake ? take : notTake;

        return dp[index];
    }

    public int rob(int[] nums) {

        int N = nums.length;

        dp = new int[N];

        Arrays.fill(dp, -1);

        return robHouse(nums, N - 1);
    }
}
```

### Bottom-Up Approach