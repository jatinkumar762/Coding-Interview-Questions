https://leetcode.com/problems/palindrome-partitioning/description/


### Approach-1 Dynamic Programming

* we can use concept of DP - Longest Palindromic Substring
* this dp table will help us to determine Palindromic Substring in $O(1)$

```java
class Solution {

    List<List<String>> result;
    boolean[][] dp;

    public void getPalPart(String s, int start, int end, List<String> data) {

        if (start >= end && data.size() > 0) {
            List<String> tmp = new ArrayList<String>();
            tmp.addAll(data);
            result.add(tmp);
            return;
        }

        for (int i = start; i < end; i++) {

            if (dp[start][i])
                data.add(s.substring(start, i + 1));
            else
                continue;

            getPalPart(s, i + 1, end, data);

            if (data.size() > 0) {
                // remove previous combination
                data.remove(data.size() - 1);
            }
        }

    }

    public List<List<String>> partition(String s) {

        longestPalindrome(s);

        result = new ArrayList<>();

        getPalPart(s, 0, s.length(), new ArrayList<String>());

        return result;
    }

    private void longestPalindrome(String s) {

        int n = s.length();
        char[] arr = s.toCharArray();

        dp = new boolean[n][n];

        // length 1 strings
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // length 2 strings
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
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
                }
            }
        }

    }
}
```

**Note:**

* this substring approach faster by 2-3ms than below StringBuilder approach

```java
for (int i = start; i < end; i++) {

    if (dp[start][i])
        data.add(s.substring(start, i + 1));
    else
        continue;

    getPalPart(s, i + 1, end, data);

    if (data.size() > 0) {
        // remove previous combination
        data.remove(data.size() - 1);
    }
}
```


```java
StringBuilder tmp = new StringBuilder("");

for (int i = start; i < end; i++) {

    tmp.append(s.charAt(i));

    if (dp[start][i])
        data.add(tmp.toString());
    else
        continue;

    getPalPart(s, i + 1, end, data);

    if (data.size() > 0)
        data.remove(data.size() - 1);
}
```