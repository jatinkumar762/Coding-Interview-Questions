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
            //Integer.MIN_VALUE = -2147483648
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

### another way to write

```java
class Solution {

    public int myAtoi(String s) {

        char[] arr = s.toCharArray();
        int len = s.length();
        double maxPositive = Math.pow(2, 31) - 1;
        double maxNegative = Math.pow(2, 31);
        int i;
        boolean positive = true;
        // "+-12"
        for (i = 0; i < len; i++) {
            if (arr[i] == ' ') {
                continue;
            } else if (arr[i] == '+') {
                i++;
                break;
            } else if (arr[i] == '-') {
                positive = false;
                i++;
                break;
            } else if ((arr[i] - 48) < 0 || (arr[i] - 48) > 9) {
                return 0;
            } else {
                break;
            }
        }

        double num = 0;
        for (; i < len; i++) {
            if (arr[i] - 48 >= 0 && arr[i] - 48 <= 9) {
                num = num * 10 + (arr[i] - 48);
            } else {
                break;
            }

            if (positive && num >= maxPositive) {
                num = maxPositive;
                break;
            } else if (!positive && num >= maxNegative) {
                num = maxNegative;
                break;
            }
        }

        return positive ? (int) num : (int) (-1 * num);
    }
}
```