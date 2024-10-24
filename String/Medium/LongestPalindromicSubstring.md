https://leetcode.com/problems/longest-palindromic-substring/description/

### Approach-1 Brute Force

1. Generate all possible sub strings
2. check if substring is palindrome or not

**Time Complexity:** $O(N^2)*O(N)$

### Approach-2 Expand Around Center

* from each index, will go its right and left dir to check palindrome
* two cases in it
  - when palindrome string odd length
    left = i-1, right = i+1
  - when even length
    left = i, right = i+1

```java
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();
        char[] arr = s.toCharArray();
        StringBuilder res;
        int left, right, count, max = 0;
        String output = "";

        for (int i = 0; i < len; i++) {

            // odd length
            res = new StringBuilder("");
            res.append(arr[i]);

            left = i - 1;
            right = i + 1;

            count = 1;
            while (left >= 0 && right < len && arr[left] == arr[right]) {
                
                count += 2;
                res.insert(0, arr[left]);
                res.append(arr[right]);

                left--;
                right++;
            }

            if (max < count) {
                max = count;
                output = res.toString();
            }

            // even length
            res = new StringBuilder("");

            left = i;
            right = i + 1;

            count = 0;
            while (left >= 0 && right < len && arr[left] == arr[right]) {
                
                count += 2;
                res.insert(0, arr[left]);
                res.append(arr[right]);

                left--;
                right++;
            }

            if (max < count) {
                max = count;
                output = res.toString();
            }

        }

        return output;
    }
}
```

**Time Complexity:** $O(N^2)$




