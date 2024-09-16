https://leetcode.com/problems/reverse-pairs/description/

#### Approach-1 

* if any number is -ve, then its double will more negative means less

```java
class Solution {
    public int reversePairs(int[] nums) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((nums[j]<0 && nums[i]>=nums[j]) || (nums[j] <= (Integer.MAX_VALUE/2) && nums[i] > (2 * nums[j])) ) {
                    count += 1;
                }
            }
        }

        return count;
    }
}
```