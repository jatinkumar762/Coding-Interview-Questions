https://leetcode.com/problems/generate-parentheses/


```java
class Solution {

    private List<String> result;

    public List<String> generateParenthesis(int n) {

        int openParenthesis = 0;
        int closeParenthesis = 0;

        result = new ArrayList<String>();

        findAllBalancedParenthesis(openParenthesis, closeParenthesis, "", n);

        return result;
    }

    private void findAllBalancedParenthesis(int openCount, int closeCount, String tmp, int n) {

        if (openCount + closeCount == 2 * n) {
            result.add(tmp);
            return;
        }

        if (openCount < n) {
            findAllBalancedParenthesis(openCount + 1, closeCount, tmp + "(", n);
        }

        if (closeCount < openCount && closeCount < n) {
            findAllBalancedParenthesis(openCount, closeCount + 1, tmp + ")", n);
        }
    }
}
```