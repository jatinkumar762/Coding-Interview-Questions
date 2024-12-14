https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

* here is only one type of parenthesis, we can efficiently handle the matching process with a counter.
* the stack-based approach is more generic and preferred for cases involving multiple types of parentheses

```java
class Solution {
    public int minAddToMakeValid(String s) {

        int openCount = 0;

        char[] charArr = s.toCharArray();

        int count = 0;

        for (char ch : charArr) {

            if (ch == '(') {
                openCount++;
            } else {

                if (openCount <= 0) {
                    count++;
                } else {
                    openCount--;
                }
            }
        }

        return count + openCount;
    }
}
```