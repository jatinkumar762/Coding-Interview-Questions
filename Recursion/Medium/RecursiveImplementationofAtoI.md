https://leetcode.com/problems/string-to-integer-atoi/

### Approach-1

```java
class Solution {

    boolean positive;
    boolean signChecked;

    public int myAtoi(String s) {

        int len = s.length();

        positive = true;

        //"+-12"
        //output - 0
        signChecked = false;

        long res = convertStringToNum(s, 0, len, 0L);

        if (positive && res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (!positive && res > Integer.MAX_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (!positive) {
            return (int) (res * -1);
        }

        return (int) res;
    }

    private long convertStringToNum(String s, int index, int len, long sum) {

        if (index == len) {
            return sum;
        }

        //s = "9223372036854775808"
        if (sum > Integer.MAX_VALUE) {
            // sum can be abs(Integer.MIN_VALUE) = Integer.MAX_VALUE + 1;
            // so can not return Integer.MAX_VALUE
            return sum;
        }

        if (s.charAt(index) == ' ' && !signChecked) {

            return convertStringToNum(s, index + 1, len, sum);

        } else if (s.charAt(index) == '+' && !signChecked) {
            //"+-12"
            signChecked = true;
            return convertStringToNum(s, index + 1, len, sum);

        } else if (s.charAt(index) == '-' && !signChecked) {

            positive = false;
            signChecked = true;
            return convertStringToNum(s, index + 1, len, sum);

        } else if (s.charAt(index) >= 48 && s.charAt(index) <= 57) {

            signChecked = true;
            return convertStringToNum(s, index + 1, len, (sum * 10 + s.charAt(index) - 48));

        }

        return sum;
    }

}
```

**Another way to write**

```java

class Solution {

    private boolean negative;
    private boolean positive;

    public int myAtoi(String s) {

        char[] arr = s.toCharArray();

        int len = s.length();
        int index = 0;

        while (index < len) {

            if (arr[index] - '0' >= 0 && arr[index] - '0' <= 9) {
                break;
            }

            // ++12 ->0
            // --12 ->0
            // +-12 ->0
            if (arr[index] == '-' && !positive && !negative) {
                negative = true;
            } else if (arr[index] == '+' && !positive && !negative) {
                positive = true;
            } else if (arr[index] == ' ' && !positive && !negative) {

            } else {
                return 0;
            }

            index++;
        }

        long number = getNumber(arr, index, len, 0L);

        if (!negative) {
            return number >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) number;
        } else {
            return number > Integer.MAX_VALUE ? Integer.MIN_VALUE : -1 * (int) number;
        }

    }

    private long getNumber(char[] arr, int index, int len, long num) {
        
        //s = "9223372036854775808"
        if (num > Integer.MAX_VALUE) {
            // sum can be abs(Integer.MIN_VALUE) = Integer.MAX_VALUE + 1;
            // so can not return Integer.MAX_VALUE
            return num;
        }

        if (index == len) {
            return num;
        }

        if (arr[index] - '0' >= 0 && arr[index] - '0' <= 9) {
            return getNumber(arr, index + 1, len, num * 10 + (arr[index] - '0'));
        }

        return num;
    }
}
```

### Approach-2

```
// Check for overflow/underflow
if (total > (Integer.MAX_VALUE - digit) / 10) {
    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; // Return appropriate bound
}
```

### Leetcode Solution

* INT_MAX = 2147483647

* INT_MIN = -2147483648


```java
class Solution {
    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if (
                (result > Integer.MAX_VALUE / 10) ||
                (result == Integer.MAX_VALUE / 10 &&
                    digit > Integer.MAX_VALUE % 10)
            ) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }
}
```