https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

https://www.geeksforgeeks.org/problems/index-of-the-first-occurrence-of-pattern-in-a-text/1

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