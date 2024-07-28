https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1

* postfix  -> will traverse from left to right

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
    
    static String postToInfix(String post_exp) {
        // code here
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
                String temp = "(" + op2 + c + op1 + ")";
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