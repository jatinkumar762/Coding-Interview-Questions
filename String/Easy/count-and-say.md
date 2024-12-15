https://leetcode.com/problems/count-and-say/description/

### Approach-1

```java
class Solution {
    public String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        if (n == 2) {
            return "11";
        }

        String prev = countAndSay(n - 1);

        return findRLE(prev);
    }

    private String findRLE(String content) {

        StringBuilder res = new StringBuilder();

        char[] arr = content.toCharArray();

        int len = arr.length;

        int count = 1;
        char prev = arr[0];

        for (int i = 1; i < len; i++) {

            if (arr[i] == prev) {
                count++;
            } else {

                res.append(count);
                res.append(prev);

                count = 1;
                prev = arr[i];
            }
        }

        res.append(count);
        res.append(prev);

        return res.toString();
    }
}
```