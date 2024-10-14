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

**Time Complexity:** $O(2^N) * O(2^M)$

**Space Complexity:** $O(N) + O(M)$

### Top-Down (Memorization)

```java
class Solution {

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();

        int len1 = text1.length();
        int len2 = text2.length();

        dp = new int[len1][len2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        longestCommonSubsequenceLength(text1Arr, text2Arr, len1 - 1, len2 - 1);

        return dp[len1-1][len2-1];
    }

    private int longestCommonSubsequenceLength(char[] text1, char[] text2, int len1, int len2) {

        if (len1 < 0 || len2 < 0) {
            return 0;
        }

        if(dp[len1][len2]!=-1){
            return dp[len1][len2];
        }

        if (text1[len1] == text2[len2]) {
            return dp[len1][len2] = 1 + longestCommonSubsequenceLength(text1, text2, len1 - 1, len2 - 1);
        }

        return dp[len1][len2] = Math.max(longestCommonSubsequenceLength(text1, text2, len1 - 1, len2),
                longestCommonSubsequenceLength(text1, text2, len1, len2 - 1));
    }
}
```

**Time Complexity:** $O(N * M)$

**Space Complexity:** $O(N * M) + O(N) + O(M)$ dp & recursion stack

### Bottom-Up (Tabulation)

```java
class Solution {

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Arr = text1.toCharArray();
        char[] text2Arr = text2.toCharArray();

        int len1 = text1.length();
        int len2 = text2.length();

        dp = new int[len1 + 1][len2 + 1];

        //no need to base case initialize default is zero

        /*
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = 0;
        }
        */

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

**Time Complexity:** $O(N * M)$

**Space Complexity:** $O(N * M)$
