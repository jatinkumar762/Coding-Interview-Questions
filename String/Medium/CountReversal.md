[Count the Reversals](https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1)

```java
class Sol
{
    int countRev (String s)
    {
        // your code here
        int len = s.length();
        if(len%2!=0)
            return -1;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(stack.size()>0){
                if(stack.peek()=='{'&&s.charAt(i)=='}'){
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        int stackSize = stack.size();
        int n=0;
        while(stack.size()>0){
            char ch = stack.pop();
            if(ch=='{')
                n++;
        }

        return (stackSize / 2 + n % 2);
    }
}
```

#### Editorail
* [https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/](https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/)