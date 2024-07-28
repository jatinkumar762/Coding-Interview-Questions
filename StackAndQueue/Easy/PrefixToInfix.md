https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1

* whenever we want to convert prefix expression -> traverse from right to left

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
    
    static String preToInfix(String pre_exp) {
        // code here
        
        Stack<String> stack = new Stack<>();
     
        // Length of expression 
        int l = pre_exp.length();
         
        // Reading from right to left 
        for(int i = l - 1; i >= 0; i--)
        {
            char c = pre_exp.charAt(i);
            if (operators.contains(c))
            {
                String op1 = stack.pop();
                String op2 = stack.pop();
                 
                // Concat the operands and operator 
                String temp = "(" + op1 + c + op2 + ")";
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
