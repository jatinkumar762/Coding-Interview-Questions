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


#### Sliding Window

* https://www.youtube.com/watch?v=xtqN4qlgr8s

```java
class Solution {

    /*
     * here will use the concept, every substring ends with a character
     * eg: b b a c b a
     * subString ends with character c are: c, ac, bac, bbac
     * we are checking in backward direction from current character
     */
    public int numberOfSubstrings(String s) {

        int[] index = new int[] { -1, -1, -1 };
        // when all three a, b and c present then index will not be -1

        int minIndex, maxIndex;
        int count = 0;

        char[] charArr = s.toCharArray();
        int len = s.length();

        for (int right = 0; right < len; right++) {

            index[charArr[right] - 'a'] = right;

            if (index[0] != -1 && index[1] != -1 && index[2] != -1) {
                // we found a, b and c
                minIndex = index[0];
                maxIndex = index[0];
                for (int i = 1; i < 3; i++) {
                    minIndex = Math.min(minIndex, index[i]);
                    maxIndex = Math.max(maxIndex, index[i]);
                }
                // we found a substring from minIndex...maxIndex
                // everything before minIndex from 0 index can also prepend inside this substring
                // they will also have at least one occurrence of all these characters a, b and c.
                
                count += 1 + minIndex;
                // 1 -> one which we found
                // minIndex -> total prepend can be 0 to minIndex-1
            }

        }

        return count;
    }
}
```

**Optimization**

* there is no use of maxIndex in calculation, can remove