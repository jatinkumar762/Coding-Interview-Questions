https://leetcode.com/problems/binary-subarrays-with-sum/description/

#### Brute Force Approach - 1814ms

* generating all possible sub strings

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int N = nums.length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += nums[j];
                if (sum == goal) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
```

#### Prefix Sum - 23ms

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int totalCount = 0;
        int currentSum = 0;
        // {prefix: number of occurrence}
        Map<Integer, Integer> freq = new HashMap<>(); // To store the frequency of prefix sums

        for (int num : nums) {
            currentSum += num;
            if (currentSum == goal){
                totalCount++;
            }

            // Check if there is any prefix sum that can be subtracted from the current sum to get the desired goal
            if (freq.containsKey(currentSum - goal)){
                totalCount += freq.get(currentSum - goal);
            }

            freq.put(currentSum, freq.getOrDefault(currentSum, 0) + 1);
        }

        return totalCount;
    }
}
```

#### Sliding Windows - 1ms

* res &rarr; countOf(sum<=goal) - countOf(sum<=goal-1)
* ex:  countOf(sum<=3) - countOf(sum<=2) &rarr; will give us count where equals to 3

goal = 2 and nums = [1,0,1,0,1]
                     0 1 2 3 4

res = 4

1 0 1
1 0 1 0
0 1 0 1
1 0 1

if we use normal sliding window approach, will not include last 1 0 1 (index 2 - 4 substring)

similarly, if i change example to 

[1, 0, 0, 1, 0, 1]

1 0 0 1
1 0 0 1 0
0 0 1 0 1
0 1 0 1
1 0 1

[0 1 0 1] & [1 0 1] -> will not include in answer if we use traditional approach

```java
class Solution {

    private int countNiceSubArray(int[] nums, int goal) {

        //bcz number are either 1 or 0
        //less than not possible
        if (goal < 0) {
            return 0;
        }

        int left = 0, right = 0;
        int count = 0, sum = 0;
        int n = nums.length;

        for (; right < n; right++) {

            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return countNiceSubArray(nums, goal) - countNiceSubArray(nums, goal - 1);
    }
}
```

