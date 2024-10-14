https://leetcode.com/problems/shortest-common-supersequence/

str1 &rarr; brute

str2 &rarr; groot

longest common subsequence &rarr; rt &rarr; length = 2

shortest common subsequence size will be &rarr; n1 + n2 - len(LCS) &rarr; 5 + 5 - 2 = 8

in above example its &rarr; bgruoote/gbrouote/ &rarr; len = 8

              g   r   o   o   t
          0   1   2   3   4   5
    
    0     0   0   0   0   0   0
    
    1     0   0   0   0   0   0  b
    
    2     0   0   1   1   1   1  r
    
    3     0   0   1   1   1   1  u
    
    4     0   0   1   1   1   2  t
    
    5     0   0   1   1   1   2  e


```java
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {

        if (str1.equals(str2)) {
            return str1;
        }


        char[] text1Arr = str1.toCharArray();
        char[] text2Arr = str2.toCharArray();

        int len1 = str1.length();
        int len2 = str2.length();

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
        
        
        int commonSubSeqMaxLen = dp[len1][len2];
        
        int shortSupSeqMinLen = len1 + len2 - commonSubSeqMaxLen;

        int maxLen = shortSupSeqMinLen;

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
                    
                    //going up - we got max from up
                    //ith char will be part of super sequence
                    res[--maxLen] = text1Arr[i-1];

                    i-=1;
                } else {
                    
                    //going left
                    //ith char will be part of super sequence
                    res[--maxLen] = text2Arr[j-1];

                    j-=1;
                }
            }
        }

        while(i>0){
            res[--maxLen] = text1Arr[i-1];
            i--;
        }

         while(j>0){
            res[--maxLen] = text2Arr[j-1];
            j--;
        }
        
        return new String(res);
    }
}
```
