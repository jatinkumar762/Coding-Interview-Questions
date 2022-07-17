[Problem](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

```java
class Solution {
    
    String[] digitStr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        char[] digitsCharArr = digits.toCharArray();
        
        LinkedList<String> result = new LinkedList<String>();
        for(int i=0;i<digitsCharArr.length;i++)
        {
            if(i==0){
                String text = digitStr[digitsCharArr[i]-'0'];
                for(int k=0;k<text.length();k++)
                    result.add(String.valueOf(text.charAt(k)));
            }
            else { 
                String text = digitStr[digitsCharArr[i]-'0'];
                int listSize = result.size();
                while(listSize-->0){
                    String tmp = result.poll();
                    for(int k=0;k<text.length();k++)
                        result.add(tmp+text.charAt(k));
                }
            }
        }
        return result;
    }
}
```