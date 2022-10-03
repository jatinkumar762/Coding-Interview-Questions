[Decode String](https://leetcode.com/problems/decode-string/)

```java
class Solution {
    public String decodeString(String s) {
        
        char[] sCharArr = s.toCharArray();
        Stack<Integer> reptCount = new Stack<Integer>();
        Stack<String> reptString = new Stack<String>();
        String res = "";
        
        for(int i=0;i<sCharArr.length;){
            if(Character.isDigit(sCharArr[i])){
                int num = 0;
                while(Character.isDigit(sCharArr[i])){
                    num = (num*10) + (sCharArr[i]-'0');
                    i++;
                }
                reptCount.add(num);
            } else if(sCharArr[i]=='['){
               reptString.push(res);
               res="";
               i++; 
            } else if(sCharArr[i]==']'){
               StringBuilder temp = new StringBuilder(reptString.pop());
               int repeatTimes = reptCount.pop();
               for (int k = 0; k < repeatTimes; k++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            } else {
                res+=sCharArr[i];
                i++;
            }
        }
        return new String(res);
    }
}
```