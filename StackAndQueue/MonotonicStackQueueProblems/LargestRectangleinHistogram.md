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

### Approach-2 Find Prev and Next smaller index

```java
class Solution {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int max = 0, left, right, sum;

        int[] prev = findPrevSmallerIndex(heights, len);

        int[] next = findNextSmallerIndex(heights, len);

        for (int i = 0; i < len; i++) {

            width = next[i] - prev[i] - 1;

            sum = width * heights[i];

            max = Math.max(max, sum);
        }

        return max;
    }

    private int[] findPrevSmallerIndex(int[] heights, int N) {

        int[] arr = new int[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }

            arr[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        return arr;
    }

    private int[] findNextSmallerIndex(int[] heights, int N) {
        int[] arr = new int[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            arr[i] = stack.isEmpty() ? N : stack.peek();

            stack.push(i);
        }

        return arr;
    }
}
```

