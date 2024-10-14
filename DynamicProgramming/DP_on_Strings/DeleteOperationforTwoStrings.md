https://leetcode.com/problems/delete-operation-for-two-strings/description/


```java
class Solution {
    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();

        int max = longestCommonSubsequence(word1, word2);

        return (len1-max) + (len2-max);

    }

    public int longestCommonSubsequence(String text1, String text2) {
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
}
```