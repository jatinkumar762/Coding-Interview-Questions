https://leetcode.com/problems/sum-of-subarray-ranges/description/

### Approach-1 Brute Force

```java
class Solution {
    public long subArrayRanges(int[] nums) {

        int len = nums.length;
        int largest, smallest;
        long sum = 0;

        for (int i = 0; i < len; i++) {
            
            largest = smallest = nums[i];
            
            for (int j = i + 1; j < len; j++) {
                
                largest = largest > nums[j] ? largest : nums[j];
                
                smallest = smallest < nums[j] ? smallest : nums[j];

                sum += largest - smallest;
            }
        }
        
        return sum;
    }
}
```

### Approach-2 

* We can concept of [Sum of Sub-array Minimum Problem](./SumofSubarrayMinimums.md)
* Result &rarr; Sum(Sub-array Maximum) - Sum(Sub-array Minimum)

arr = [1, 2, 3]

1      &rarr; 1 - 1\
1 2    &rarr; 2 - 1\
1 2 3   &rarr; 3 - 1 

2     &rarr; 2 - 2 \
2 3   &rarr; 3 - 2

3     &rarr; 3 - 3

result &rarr; (1-1) + (2-1) + (3-1) + (2-2) + (3-2) + (3-3) &larr; Sum(Sub-array Maximum) - Sum(Sub-array Minimum)