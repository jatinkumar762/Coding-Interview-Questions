* [Longest Prefix Suffix](https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1)
* [Longest Happy Prefix](https://leetcode.com/problems/longest-happy-prefix/)

```java
/**
* Compute temporary array to maintain size of suffix which is same as prefix
* Time/space complexity is O(size of pattern)
*/
class Solution {
    public String longestPrefix(String s) {
        
        if(s.length()==1)
            return "";
        
        // code here
        int len = s.length();
        
        int[] count = new int[s.length()];
        
        count[0] = 0;
        for(int i=0,j=i+1;j<len;){
            if(s.charAt(i)==s.charAt(j)){
                count[j] = i+1;
                j++; i++;
            } else {
                if(i!=0){
                    i = count[i-1];
                } else {
                    count[j]=0;
                    j++;
                }
            } 
        }
        
        return s.substring(0,count[len-1]);
    }
}
```
