https://leetcode.com/problems/longest-palindromic-substring/description/

### Approach-1 Brute Force

1. Generate all possible sub strings
2. check if substring is palindrome or not

**Time Complexity:** $O(N^2)*O(N)$

### Approach-2 Expand Around Center

* from each index, will go its right and left dir to check palindrome
* two cases in it
  - when palindrome string odd length
    left = i-1, right = i+1
  - when even length
    left = i, right = i+1

```java
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();
        char[] arr = s.toCharArray();
        StringBuilder res;
        int left, right, count, max = 0;
        String output = "";

        for (int i = 0; i < len; i++) {

            // odd length
            res = new StringBuilder("");
            res.append(arr[i]);

            left = i - 1;
            right = i + 1;

            count = 1;
            while (left >= 0 && right < len && arr[left] == arr[right]) {
                
                count += 2;
                res.insert(0, arr[left]);
                res.append(arr[right]);

                left--;
                right++;
            }

            if (max < count) {
                max = count;
                output = res.toString();
            }

            // even length
            res = new StringBuilder("");

            left = i;
            right = i + 1;

            count = 0;
            while (left >= 0 && right < len && arr[left] == arr[right]) {
                
                count += 2;
                res.insert(0, arr[left]);
                res.append(arr[right]);

                left--;
                right++;
            }

            if (max < count) {
                max = count;
                output = res.toString();
            }

        }

        return output;
    }
}
```

**Time Complexity:** $O(N^2)$

### Approach-3 Dynamic Programming

![DP Table](./DP%20-%20Longest%20Palindromic%20Substring.png)

```java
class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();

        boolean[][] dp = new boolean[n][n];

        int maxLen = 1, maxIndex = 0;

        // length 1 strings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // length 2 strings
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                maxLen = 2;
                maxIndex = i;
                dp[i][i + 1] = true;
            }
        }

        // max length can go till original string len

        for (int l = 3; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                // Ending index
                int j = i + l - 1;
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (maxLen < l) {
                        maxLen = l;
                        maxIndex = i;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder("");

        for (int index = maxIndex; index < (maxIndex + maxLen); index++) {
            res.append(arr[index]);
        }

        return res.toString();
    }
}
```

**Time Complexity:** $O(N^2)$ where n is the length of the string, due to the nested loops filling the DP table.

**Space Complexity:** $O(N^2)$ for the DP table.


