https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

```java
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        char[] text1Arr = str1.toCharArray();
        char[] text2Arr = str2.toCharArray();

        int len1 = str1.length();
        int len2 = str2.length();
        
        int maxComStrLen = 0;
        for(int i = 0; i < len1; i++) {
            for(int j = 0; j < len2; j++) {
                
                int curr = 0;
                for(; (i+curr<len1) && (j+curr<len2); curr++){
                    if(text1Arr[i+curr] != text2Arr[j+curr]){
                        break;
                    }
                }
                maxComStrLen = Math.max(curr, maxComStrLen);
            }
        }
        
        return maxComStrLen;
    } 
}
```

**Time Complexity:** $O(m x n x min(m, n))$

**Auxiliary Space:** $O(1)$


### Dynamic Programming - Tabulation

```java
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        char[] text1Arr = str1.toCharArray();
        char[] text2Arr = str2.toCharArray();

        int len1 = str1.length();
        int len2 = str2.length();
        
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1Arr[i - 1] == text2Arr[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0; //wont consider previous substring
                }
                
                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }
    
}
```

**Note:** Space Optimization possible using curr and prev

```java
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        char[] text1Arr = str1.toCharArray();
        char[] text2Arr = str2.toCharArray();

        int len1 = str1.length();
        int len2 = str2.length();
        
        
        int[] prev = new int[len2+1];
        
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            
            int[] curr = new int[len2+1];
            
            for (int j = 1; j <= len2; j++) {
                
                if (text1Arr[i - 1] == text2Arr[j - 1]) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = 0; //wont consider previous substring
                }
                
                max = Math.max(curr[j], max);
            }
            
            prev = curr;
        }

        return max;
    }
    
}
```