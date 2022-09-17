[GFG-Problem](https://practice.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/1)

#### Method-1: Using Longest Prefix as Suffix logic

```java
class Solution {
    
    static int[] findLSP(String str){
        int[] lsp = new int[str.length()];
        int i=0;
        lsp[0]=0;
        for(int j=1;j<str.length();){
            if(str.charAt(i)==str.charAt(j)){
                lsp[j]=i+1;
                i++;
                j++;
            } else if(i==0) {
                lsp[j] = 0;
                j++;
            } else {
                i = lsp[i-1];
            }
        }
        return lsp;
    }
    
    public static int minChar(String str) {
       //Write your code here
       int len = str.length();
       
       StringBuilder strBuilder = new StringBuilder(str);
       
       str = str + "$" + new String(strBuilder.reverse());
       
       int[] lsp = findLSP(str);
       
       return len - lsp[str.length()-1];
    }
}
```

#### Editorial
* [https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/](https://www.geeksforgeeks.org/minimum-characters-added-front-make-string-palindrome/)