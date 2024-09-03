https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

#### BruteForce - TLE

```java
class Solution {
    public int numberOfSubstrings(String s) {

        char[] charArr = s.toCharArray();
        int len = s.length();
        int count = 0, a, b, c;

        for (int i = 0; i < len; i++) {
            a = 0;
            b = 0;
            c = 0;
            for (int j = i; j < len; j++) {

                if (charArr[j] == 'a') {
                    a++;
                } else if (charArr[j] == 'b') {
                    b++;
                } else if (charArr[j] == 'c') {
                    c++;
                }

                if (a > 0 && b > 0 && c > 0) {
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