https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/

* we can insert any character anywhere
* max insertion - just reverse of string we will add  &rarr; length of string
  - abc + cba &rarr; abccba
* in question it asked min insertion ?
* result = n - longest palindromic subsequence

```java
class Solution {
    public int minInsertions(String s) {
        
        int len = s.length();

        return len - longestPalindromeSubseq(s);
    }

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

