https://leetcode.com/problems/word-break/description/

### Approach-1 Recursion (TLE)

* we consider each prefix and search for it in dictionary. 
* If the prefix is present in dictionary, we recur for rest of the string (or suffix).

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();

        if (len == 0) {
            return true;
        }

        StringBuilder res = new StringBuilder("");

        for (int i = 0; i < len; i++) {
            res.append(s.charAt(i));

            if (wordDict.contains(res.toString()) && wordBreak(s.substring(i + 1), wordDict)) {
                return true;
            }
        }

        return false;
    }
}
```

### Dynamic Programming - (Right to Left)

* will create a boolean array of input string length size
* now will travel string from right side
* now for each index, we check if [index...len-1] word break possible
  - case 1: if [index...len-1] whole substring exist &rarr; dp[index] = true;
  - case 2: if [index...K] only this word exist in dict and k < len &rarr; dp[index] = dp[K+1];


```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();

        if (len == 0) {
            return true;
        }

        boolean[] dp = new boolean[len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 1; j <= len - i; j++) {

                boolean dict = wordDict.contains(s.substring(i, i + j));

                /*
                if ((i + j) < len) {
                    dp[i] = dict && dp[i + j];
                } else {
                    dp[i] = dict;
                }
                */

                dp[i] = dict && ((i + j) < len ? dp[i + j] : true);

                if (dp[i]) {
                    break;
                }
            }
        }

        //System.out.println(Arrays.toString(dp));

        return dp[0];
    }
}
```