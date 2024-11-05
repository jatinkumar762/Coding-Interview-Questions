https://leetcode.com/problems/largest-rectangle-in-histogram/description/

### Approach-1 using all possible substrings

```java
class Solution {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int min, max = 0, width;

        for (int i = 0; i < len; i++) {
            min = heights[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, heights[j]);
                width = j - i + 1;
                max = Math.max(max, min * width);
            }
        }

        return max;
    }
}
```