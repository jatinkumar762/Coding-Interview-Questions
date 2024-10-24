https://leetcode.com/problems/longest-palindromic-substring/description/

### Approach-1 Brute Force

1. Generate all possible sub strings
2. check if substring is palindrome or not

**Time Complexity:** $O(N^2)$

### Approach-2 Expand Around Center

* from each index, will go its right and left dir to check palindrome
* two cases in it
  - when palindrome string odd length
    left = i-1, right = i+1
  - when even length
    left = i, right = i+1

```java

```