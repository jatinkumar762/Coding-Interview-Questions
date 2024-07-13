https://leetcode.com/problems/string-to-integer-atoi/description/

```java
class Solution {
    private boolean negative;
    public int myAtoi(String s) {
        

        char[] charArr = s.toCharArray();

        int i=0;
        int num=0;
        while(i<charArr.length && charArr[i]==' '){
            i++;
        }

        if(i<charArr.length && (charArr[i]=='-' || charArr[i]=='+')){
            negative = charArr[i]=='-' ? true:false;
            i++;
        }

        while(i<charArr.length && charArr[i]>='0' && charArr[i]<='9'){
            
            //overflow check
            //bcz if add more element to num then overflow will happen
            //The value of Integer.MAX_VALUE is 2^31-1, which is 2,147,483,647
            if(num> Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && charArr[i]-'0'>7)){
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            num = num*10 + charArr[i]-48;
            i++;
        }

        return negative ? (-1*num) : num;
    }
}

//imp test cases
// "+1", ""
```