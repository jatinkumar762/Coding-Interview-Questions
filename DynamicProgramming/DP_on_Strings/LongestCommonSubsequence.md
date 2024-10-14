https://leetcode.com/problems/longest-common-subsequence/description/

### Recursive

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();

        int len1 = text1.length();
        int len2 = text2.length();

        return longestCommonSubsequenceLength(text1Arr, text2Arr, len1 - 1, len2 - 1);
    }

    private int longestCommonSubsequenceLength(char[] text1, char[] text2, int len1, int len2) {

        if (len1 < 0 || len2 < 0) {
            return 0;
        }

        if (text1[len1] == text2[len2]) {
            return 1 + longestCommonSubsequenceLength(text1, text2, len1 - 1, len2 - 1);
        }

        return 0 + Math.max(longestCommonSubsequenceLength(text1, text2, len1 - 1, len2),
                longestCommonSubsequenceLength(text1, text2, len1, len2 - 1));
    }
}
```

