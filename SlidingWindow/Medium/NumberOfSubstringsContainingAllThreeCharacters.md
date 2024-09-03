https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

#### BruteForce - TLE

```java
class Solution {
    public int numberOfSubstrings(String s) {

        char[] charArr = s.toCharArray();
        int len = s.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            int[] freq = { 0, 0, 0 };
            for (int j = i; j < len; j++) {

                freq[charArr[j] - 'a']++;

                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    count += 1 + (len - 1 - j);
                    // bcz remaining will also satify
                    // abc -> abca, abcab, abcabc
                    break;
                }
            }
        }

        return count;
    }
}
```