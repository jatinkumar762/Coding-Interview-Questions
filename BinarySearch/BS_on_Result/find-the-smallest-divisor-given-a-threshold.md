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

        /*
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
        */

        for (int num : nums) {
          sum += (num + div - 1) / div; // Equivalent to Math.ceil(num / mid)
        }

        return sum;
    }
}
```

* The expression $(num+div−1/div)$ is a way to compute the ceiling of the division $(num/div)$ without directly using the ceiling function.
* By adding div − 1 to num, you are effectively adjusting the numerator in such a way that if there's any remainder in the division, it causes the quotient to "round up.
* This adjustment works because:
  - If num is exactly divisible by div, the addition doesn't change the result.
  - If there's a remainder (i.e., num % div ≠ 0 ), adding div-1 ensures that the next integer value is reached when you perform the integer division.

1. 6 &rarr; 6 + 3 - 1 = 8 &rarr; 8/3 = 2
2. 7 &rarr; 7 + 3 - 1 = 9 &rarr; 9/3 = 3
3. 8 &rarr; 8 + 3 - 1 = 10 &rarr; 10/3 = 3

but if we add div, it will change the result.
 
