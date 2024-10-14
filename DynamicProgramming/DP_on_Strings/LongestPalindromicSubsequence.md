https://leetcode.com/problems/longest-palindromic-subsequence/description/

* this problem is extension of DP - Longest Common Subsequence

str1 = s

str2 = s.reverse()

```java
class Solution {
    public int longestPalindromeSubseq(String s) {

        String text1 = s;
        String text2 = reverse(s);

        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();

        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1Arr[i - 1] == text2Arr[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[len1][len2];
    }

    private String reverse(String text) {

        char[] arr = text.toCharArray();
        int len = text.length();

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return new String(arr);
    }
}
```