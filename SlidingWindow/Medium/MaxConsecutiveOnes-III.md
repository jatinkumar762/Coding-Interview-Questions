https://leetcode.com/problems/max-consecutive-ones-iii/description/

#### Approach-1 Sliding Window

* we need to maintain count of zero
* if zero count goes above k, then we need to update the value of left pointer
* will update left pointer, until zero count become k

```java
class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0, zero = 0;
        int N = nums.length;
        int max = 0;

        for (; right < N; right++) {

            if (nums[right] == 0) {
                zero++;
            }

            while (zero > k) {
                if (nums[left] == 0) {
                    zero--; // after this zero will becomem less than k
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
```

**More Optimized** 

&rarr; need to remove this while loop

* when $zero>k$, will not update max and move window more left side (update left only)

```java
class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0, right = 0, zero = 0;
        int N = nums.length;
        int max = 0;

        for (; right < N; right++) {

            if (nums[right] == 0) {
                zero++;
            }

            if (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

            if (zero <= k) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}
```