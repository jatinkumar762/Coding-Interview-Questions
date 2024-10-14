https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1

```java
class Solution {
    public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        char[] text1Arr = s.toCharArray();
        char[] text2Arr = t.toCharArray();

        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1Arr[i - 1] == text2Arr[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        
        int maxLen = dp[len1][len2];
        
        char[] res = new char[maxLen];
        
        int i = len1, j = len2;
        
        while(i > 0 && j > 0){
            
            if(text1Arr[i-1] == text2Arr[j-1]){
                //diagonal
                res[--maxLen] = text1Arr[i-1];
                i-=1;
                j-=1;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]){
                    i-=1;
                } else {
                    j-=1;
                }
            }
        }
        
        List<String> response = new ArrayList<>();
        response.add(new String(res));
        return response;
    } 
}
```