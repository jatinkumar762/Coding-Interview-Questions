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