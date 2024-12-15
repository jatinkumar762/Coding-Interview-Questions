https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

https://www.geeksforgeeks.org/problems/index-of-the-first-occurrence-of-pattern-in-a-text/1

### Naive Approach

```java
class Solution {
    public int strStr(String haystack, String needle) {

        int len1 = haystack.length();
        int len2 = needle.length();

        if (len1 == 0)
            return 0;

        if (len2 == 0 || len2 > len1)
            return -1;

        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();

        int j;
        for (int i = 0; i <= (len1 - len2); i++) {

            j = 0;

            while (j < len2 && arr2[j] == arr1[i + j]) {
                j++;
            }

            if (j == len2)
                return i;
        }

        return -1;
    }
}
```

**Time Complexity:** O(t * p)

### KMP Algorithm

```java
class Solution {

    public int strStr(String text, String pattern) {

        int[] lpsArr = lps(pattern);

        int textLen = text.length();
        int pattLen = pattern.length();

        char[] textArr = text.toCharArray();
        char[] pattArr = pattern.toCharArray();

        int i = 0, j = 0;
        for (; i < textLen && j < pattLen;) {

            if (textArr[i] == pattArr[j]) {
                i++;
                j++;
            } else {

                if (j != 0) {
                    j = lpsArr[j - 1];
                } else {
                    i++;
                }
            }
        }

        if (j == pattLen) {
            return i - j;
        }

        return -1;
    }

    private int[] lps(String pattern) {

        int len = pattern.length();

        // lps array
        int[] arr = new int[len];

        char[] charArr = pattern.toCharArray();

        arr[0] = 0;

        for (int i = 0, j = 1; j < len;) {

            if (charArr[j] == charArr[i]) {

                arr[j] = i + 1;

                i++;
                j++;
            } else {

                if (i == 0) {
                    arr[j] = 0;
                    j++;
                } else {
                    i = arr[i - 1];
                }
            }
        }

        return arr;
    }
}
```

**Time Complexity:** O(t + p)