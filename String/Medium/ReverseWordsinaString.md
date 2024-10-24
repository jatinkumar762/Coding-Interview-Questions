https://leetcode.com/problems/reverse-words-in-a-string/description/

### Approach-1 Using Two Pointer

```java
class Solution {
    public String reverseWords(String s) {

        StringBuilder res = new StringBuilder("");

        char[] arr = s.toCharArray();

        int len = s.length();

        int i, j;
        for (i = len - 1; i >= 0;) {

            while (i >= 0 && arr[i] == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            j = i;
            while (j >= 0 && arr[j] != ' ') {
                j--;
            }

            if (j == -1 && i >= 0) {
                res.append(s.substring(0, i + 1));
            } else if (j <= i && j >= 0) {
                res.append(s.substring(j + 1, i + 1)).append(" ");
            }

            i = j;
        }

        //"  hello world  "
        //"world hello " if we dont use trim
        return res.toString().trim();
    }
}
```