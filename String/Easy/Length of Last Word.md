https://leetcode.com/problems/length-of-last-word/description/

### Approach-1 String Index Manipulation

```java
class Solution {
    public int lengthOfLastWord(String s) {

        int len = s.length();
        int i = len - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int end = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }

        return end - i;
    }
}
```

### Approach-2 One-loop Iteration

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int p = s.length(), length = 0;
        while (p > 0) {
            p--;
            // we're in the middle of the last word
            if (s.charAt(p) != ' ') {
                length++;
            }
            // here is the end of last word
            else if (length > 0) {
                return length;
            }
        }
        return length;
    }
}
```