[Leetcode - Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length()!=t.length())
                return false;
        
        int[] keyS = new int[256];
        int[] keyT = new int[256];
        
        Arrays.fill(keyS, -1);
        Arrays.fill(keyT, -1);
        
        for(int i=0;i<s.length();i++){
            char cS = s.charAt(i);
            char tS = t.charAt(i);
            
            if(keyS[cS]!=-1 && keyS[cS]!=tS)
                return false;
            
            if(keyT[tS]!=-1 && keyT[tS]!=cS)
                return false;
            
            keyS[cS]=tS;
            keyT[tS]=cS;
        }
        return true;
    }
}
```