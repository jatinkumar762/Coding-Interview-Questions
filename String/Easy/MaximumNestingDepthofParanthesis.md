https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

```java
class Solution {

    public int maxDepth(String s) {

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int open = 0;
        int maxOpen = 0;

        for (char ch : arr) {
            if (ch == '(') {
                open += 1;
            } else if (ch == ')') {
                open -= 1;
            }
            maxOpen = maxOpen > open ? maxOpen : open;
        }
        return maxOpen;
    }
}
```