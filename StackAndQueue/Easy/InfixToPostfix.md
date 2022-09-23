[https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/](https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/)


```java
class Solution {
    
    int priority(char ch)
    {    
        switch(ch)
        {
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
            case '^': return 3;
        }
        return 0;
    }
    
    
    String infixToPostfix(String str){
        
        char[] arr = str.toCharArray();
        
        StringBuilder result = new StringBuilder();
        
        Stack<Character> operator = new Stack<Character>();
        
        for(char ch : arr){
            
            if(ch==' ')
                continue;
            
            if(ch-'0'>=0 && ch-'0'<=9){
                result.append(ch);
            } else if(ch=='(') {
                operator.push(ch);
            } else if (ch==')'){
                while(operator.size()>0){
                    char tmp = operator.pop();
                    if(tmp!='(')
                        result.append(tmp);
                }
            } else {
                while(operator.size()>0 && (priority(ch)>=priority(operator.peek()))){
                   char tmp = operator.pop();
                   if(tmp!='(') result.append(tmp);
                }
                operator.push(ch);
            }
        }
        
        while(operator.size()>0){
           char tmp = operator.pop();
           if(tmp!='(') result.append(tmp);
        }
        
        return new String(result);
    }
    
    int evaluatePostfix(String postfix){
        
        Stack<Integer> operand = new Stack<Integer>();
        for(char ch : postfix.toCharArray()){
            if(ch-'0'>=0 && ch-'0'<=9){
                operand.push(ch-'0');
            } else {
                int val1 = operand.pop();
                int val2 = operand.pop();
                switch(ch)
                {
                    case '+':
                    operand.push(val2+val1);
                    break;
                     
                    case '-':
                    operand.push(val2- val1);
                    break;
                     
                    case '/':
                    operand.push(val2/val1);
                    break;
                     
                    case '*':
                    operand.push(val2*val1);
                    break;
              }
            }
        }
        return operand.peek();   
    }
    
    public int calculate(String s) {
        String postfixExpr = infixToPostfix(s);
        System.out.println(postfixExpr);
        return evaluatePostfix(postfixExpr);
    }
}
```