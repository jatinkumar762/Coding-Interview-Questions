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

### Approach - 3 TLE Solution

```java
class Solution {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        int max = 0, width, sum, next, prev;

        // int[] prev = findPrevSmallerIndex(heights, len);
        // int[] next = findNextSmallerIndex(heights, len);

        for (int i = 0; i < len; i++) {

            prev = i - 1;
            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev--;
            }

            next = i + 1;
            while (next < len && heights[next] >= heights[i]) {
                next++;
            }

            width = next - prev - 1;

            sum = width * heights[i];

            max = Math.max(max, sum);
        }

        return max;
    }
}
```

**Note:** Another way to compute Next smaller element

```java
 // Function to find next smaller for every element
static int[] nextSmaller(int[] hist) {
    int n = hist.length;

    // Initialize with n for the cases when next smaller
    // does not exist
    int[] nextS = new int[n];
    for (int i = 0; i < n; i++) {
        nextS[i] = n;
    }

    Stack<Integer> st = new Stack<>();

    // Traverse all array elements from left to right
    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && hist[i] < hist[st.peek()]) {

            // Setting the index of the next smaller element
            // for the top of the stack
            nextS[st.pop()] = i;
        }
        st.push(i);
    }
    return nextS;
}
```

### Further Optimized (The Best Approach) – O(n) Time and O(n) Space

* When we compute next smaller element, we pop an item from the stack and mark current item as next smaller of it.
* One important observation here is the item below every item in stack is the previous smaller element. 
* So we do not need to explicitly compute previous smaller. 

```java
class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int res = 0, tp, curr;

        for (int i = 0; i < n; i++) {

            // Process the stack while the current element
            // is smaller than the element corresponding to
            // the top of the stack
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {

                // The popped item is to be considered as the
                // smallest element of the histogram
                tp = s.pop();

                // For the popped item, previous smaller element
                // is just below it in the stack (or current stack
                // top) and next smaller element is i
                int width = s.isEmpty() ? i : i - s.peek() - 1;

                // Update the result if needed
                res = Math.max(res, heights[tp] * width);
            }
            s.push(i);
        }

        // For the remaining items in the stack, next smaller does
        // not exist. Previous smaller is the item just below in
        // the stack.
        while (!s.isEmpty()) {
            tp = s.pop();
            curr = heights[tp] * (s.isEmpty() ? n : n - s.peek() - 1);
            res = Math.max(res, curr);
        }

        return res;
    }
}
```
