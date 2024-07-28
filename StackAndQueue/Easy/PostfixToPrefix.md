https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1

* postfix conversion - will traverse from left to right

```java
class Solution {
    private static Set<Character> operators = new HashSet<>(){{
        add('+');
        add('-');
        add('*');
        add('/');
        add('^');
        add('%');
    }};
    
    static String postToPre(String post_exp) {
        // code here
        Stack<String> stack = new Stack<>();
     
        // Length of expression 
        int l = post_exp.length();
         
        // Reading from left to right 
        for(int i = 0; i < l; i++)
        {
            char c = post_exp.charAt(i);
            if (operators.contains(c))
            {
                String op1 = stack.pop();
                String op2 = stack.pop();
                 
                // Concat the operands and operator 
                String temp = c + op2 + op1;
                stack.push(temp);
            } 
            else
            {
                // To make character to string
                stack.push(c + ""); 
            }
        }
        return stack.pop();
    }
}
```