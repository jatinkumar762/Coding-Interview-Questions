https://leetcode.com/problems/merge-strings-alternately/description/


### Approach-1 Using 2 Pointers

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        char[] res = new char[len1 + len2];

        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {

            res[k++] = word1.charAt(i++);
            res[k++] = word2.charAt(j++);
        }

        while (i < len1) {
            res[k++] = word1.charAt(i++);
        }

        while (j < len2) {
            res[k++] = word2.charAt(j++);
        }

        return new String(res);
    }
}
```

### Approach-2 Using Single Pointer

```java
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                result.append(word1.charAt(i));
            }
            if (i < n) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }
}
```