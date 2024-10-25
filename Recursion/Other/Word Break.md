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