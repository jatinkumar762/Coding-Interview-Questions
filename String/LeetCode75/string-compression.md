https://leetcode.com/problems/string-compression/description/


### Approach-1 (1ms Beats-99.57)

```java
class Solution {
    public int compress(char[] chars) {

        char prev = chars[0];
        int count = 1;
        int len = chars.length;

        StringBuilder output = new StringBuilder("");

        for (int i = 1; i < len; i++) {

            if (chars[i] == prev) {
                count++;
            } else {

                output.append(prev);
                if (count > 1) {
                    output.append(count);
                }

                prev = chars[i];
                count = 1;
            }
        }

        output.append(prev);
        if (count > 1) {
            output.append(count);
        }

        int outputLen = output.length();
        for (int i = 0; i < outputLen; i++) {
            chars[i] = output.charAt(i);
        }

        return outputLen;
    }
}
```


### Approach-2

```java
class Solution {
    public int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }
}
```
