https://leetcode.com/problems/count-number-of-nice-subarrays/description/

#### Sliding Window

* similar to problem - https://leetcode.com/problems/binary-subarrays-with-sum/description/

```java
class Solution {

    private int countNiceSubArray(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }
        int left = 0, right = 0;
        int count = 0, odd = 0;
        int n = nums.length;

        for (; right < n; right++) {

            if ((nums[right] & 1) == 1) {
                odd++;
            }

            while (odd > k) {
                if ((nums[left] & 1) == 1) {
                    odd--;
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return countNiceSubArray(nums, k) - countNiceSubArray(nums, k - 1);
    }
}
```