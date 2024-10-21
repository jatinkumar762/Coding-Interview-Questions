https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

```java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;
        int min = 1;
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            max = max > nums[i] ? max : nums[i];
        }

        int res = 0, mid, midDivSum;
        while (min <= max) {

            mid = min + (max - min) / 2;

            midDivSum = calDivisonSum(nums, mid, n);

            if (midDivSum <= threshold) {
                res = mid;
                max = mid - 1; // to Find the smallest divisor
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    private int calDivisonSum(int[] nums, int div, int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= div) {
                sum += 1;
            } else {
                sum += nums[i] / div;

                if (nums[i] % div != 0) {
                    sum += 1;
                }
            }
        }

        return sum;
    }
}
```