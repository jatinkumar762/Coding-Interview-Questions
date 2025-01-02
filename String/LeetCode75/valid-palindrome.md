https://leetcode.com/problems/valid-palindrome/description/

### Approach-1

```java
class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder str = new StringBuilder("");

        for (char ch : s.toCharArray()) {

            if ((ch >= 48 && ch <= 57) || (ch >= 97 && ch <= 122)) {
                str.append(ch);
            } else if (ch >= 65 && ch <= 90) {
                str.append((char) (ch + 32));
            }
        }

        int len = str.length();

        int i = 0, j = len - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
```

### Approach-2

```java
class Solution {
    public boolean isPalindrome(String s) {

        int len = s.length();

        int i = 0, j = len - 1;

        while (i < j) {

            while (i < j && !isAlphaNumeric(s.charAt(i))) {
                i++;
            }

            while (i < j && !isAlphaNumeric(s.charAt(j))) {
                j--;
            }

            if (toLower(s.charAt(i)) != toLower(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char ch) {

        if ((ch >= 48 && ch <= 57) || (ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90)) {
            return true;
        }

        return false;
    }

    private char toLower(char ch) {

        if (ch >= 65 && ch <= 90) {
            return (char) (ch + 32);
        }

        return ch;
    }
}
```