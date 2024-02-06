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

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length()!=t.length()) return false;

        int[] m1 = new int[256]; //default value is 0
        int[] m2 = new int[256];
        
        for(int i=0;i<s.length();i++){
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i+1;
            m2[t.charAt(i)] = i+1;
        }
        return true;  
    }
}
```