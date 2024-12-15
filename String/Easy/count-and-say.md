https://leetcode.com/problems/count-and-say/description/

### Approach-1 - 1ms

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

**another way to write** - 2ms

```java
public String countAndSay(int n) {
    String current = "1", next;

    for (int i = 2; i <= n; i++) {
        next = findRLE(current);
        current = next;
    }

    return current;
}
```

**Another approach** - 7ms

```java
class Solution {
    public String countAndSay(int n) {

        String current = "1";

        StringBuilder next;

        for (int i = 2; i <= n; i++) {

            int currLen = current.length();

            next = new StringBuilder("");

            for (int j = 0, k = 0; j < currLen; j = k) {

                while (k < currLen && current.charAt(k) == current.charAt(j)) {
                    k++;
                }

                next.append(Integer.toString(k - j));
                next.append(current.charAt(j));
            }

            current = next.toString();
        }

        return current;
    }

}
```