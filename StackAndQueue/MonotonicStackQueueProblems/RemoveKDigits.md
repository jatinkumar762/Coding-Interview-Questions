https://leetcode.com/problems/remove-k-digits/description/

**Edge Cases**

* when num.length == k &rarr; 0
* "000"
* "123456" & k =3

we need to remove higher number to make it smaller

if any number has grater number before it, will remove it.


```java
class Solution {
    public String removeKdigits(String num, int k) {

        int len = num.length();

        if (len == k) {
            return "0";
        }

        char[] charArr = num.toCharArray();

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        for (; i < len; i++) {

            int ele = charArr[i] - 48;

            while (!stack.isEmpty() && k > 0 && stack.peek() > ele) {
                stack.pop();
                k--;
            }

            if (stack.isEmpty() && ele == 0) {
                continue;
            }

            stack.push(ele);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        if(stack.isEmpty()){
            return "0";
        }

        StringBuilder res = new StringBuilder("");

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
```