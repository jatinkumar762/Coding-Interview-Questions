https://www.geeksforgeeks.org/convert-infix-prefix-notation/

**Step 1:** Reverse the infix expression. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.

**Step 2:** Convert the reversed infix expression to “nearly” postfix expression.

**While converting to postfix expression, instead of using pop operation to pop operators with greater than or equal precedence, here we will only pop the operators from stack that have greater precedence.**

**Step 3:** Reverse the postfix expression.