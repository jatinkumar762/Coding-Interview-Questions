* [Longest Prefix Suffix](https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1)
* [Longest Happy Prefix](https://leetcode.com/problems/longest-happy-prefix/)

Pattern - a a b a a b a a a

Prefix/Suffix Array - [0, 1, 0, 1, 2, 3, 4, 5, 2]

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

        for(int i=0, j=i+1; j<len; ){
            
            if(s.charAt(i) == s.charAt(j)){
                
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

#### KMP Pattern search code implementation

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    private static int[] lps(String s) {
        // code here
        int len = s.length();
        
        int[] count = new int[s.length()];
        
        count[0] = 0;
        if(s.length()==1)
            return count;
            
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
        return count;
    }
    
    private static boolean KMP(String text, String pattern){
        int[] count = lps(pattern);
        int i=0,j=0;
        while(i<text.length() && j<pattern.length()){
            
            if(text.charAt(i)==pattern.charAt(j)){
                i++;j++;
            } else {
                if(j!=0){
                    j = count[j-1];
                } else {
                    i++;
                }
            }
        }
        if(j==pattern.length())
          return true;
        return false;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String text = "THIS IS A TEST TEXT";
		String pattern = "TEST";
		
		boolean result = KMP(text, pattern);
		System.out.println(result);
	}
}
```
