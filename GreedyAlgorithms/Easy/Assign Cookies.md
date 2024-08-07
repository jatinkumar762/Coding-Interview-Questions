https://leetcode.com/problems/assign-cookies/description/

```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gLen = g.length;
        int sLen = s.length;

        int i = 0, j = 0;
        while (i < gLen && j < sLen) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
```
