https://leetcode.com/problems/jump-game/description/

* we need to track, maxIndex we can go from currentIndex

```java
class Solution {
    public boolean canJump(int[] nums) {

        int maxIndex = 0;
        int N = nums.length;

        for (int index = 0; index < N; index++) {

            if (index <= maxIndex) {

                maxIndex = Math.max(maxIndex, index + nums[index]);

                if (maxIndex >= N - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
```