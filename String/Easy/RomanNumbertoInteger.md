https://leetcode.com/problems/roman-to-integer/

```java
class Solution {
    // Finds decimal value of a given roman numeral
    
    public int charToDecimal(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
    
    public int romanToDecimal(String str) {
        // code here
        int len = str.length();
        int res=charToDecimal(str.charAt(len-1));
        for(int i=len-2;i>=0;i--){
            
            int curr = charToDecimal(str.charAt(i));
            int next = charToDecimal(str.charAt(i+1));
            if( curr < next){
                res-=curr;
            } else {
                res+=curr;
            }
        }
        return res;
    }
}
```