https://www.geeksforgeeks.org/problems/better-string/1

### Approach-1 

* will give TLE

```java
class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        
        int c1 = countDistinctSubSequences(str1);
        int c2 = countDistinctSubSequences(str2);
        
        return c1 >= c2 ? str1 : str2;
        
    }
    
    private static int countDistinctSubSequences(String str){
        
        Set<String> distStrings = new HashSet<>();
        
        int N = str.length();

        // 2^N
        int totalSubSequences = 1 << N;

        for (int i = 0; i < totalSubSequences; i++) {

            StringBuilder tmp = new StringBuilder("");

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp.append(str.charAt(j));
                }
            }

            distStrings.add(tmp.toString());
        }
        
        return distStrings.size();
    }
}
```

### Approach-2 Using Dynamic Programming

```java
class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        
        int c1 = countDistinctSubsequences(str1);
        int c2 = countDistinctSubsequences(str2);
        
        return c1 >= c2 ? str1 : str2;
        
    }
    
    private static int countDistinctSubsequences(String str) {
        int n = str.length();
        // dp[i] will hold the count of distinct subsequences of str[0..i-1]
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string has one subsequence (the empty subsequence)

        // Last occurrence map to track the last position of each character
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char currentChar = str.charAt(i - 1);
            dp[i] = 2 * dp[i - 1]; // Each subsequence can either include or exclude str[i-1]

            // If the character has appeared before, subtract the subsequences that were counted twice
            if (lastOccurrence.containsKey(currentChar)) {
                int lastIndex = lastOccurrence.get(currentChar);
                dp[i] -= dp[lastIndex - 1]; // Correct the double count
            }

            // Update last occurrence
            lastOccurrence.put(currentChar, i);
        }

        // Total distinct subsequences are all - 1 (subtracting the empty subsequence)
        return dp[n] - 1;
    }
}
```