[Valid Substring](https://practice.geeksforgeeks.org/problems/valid-substring0624/1)

```java
//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        int maxLen=0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        stack.push(-1);
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){
                stack.push(i);
            }
            else{
                
                if(stack.size()>0) {
                    stack.pop();
                }
                
                if(stack.size()>0) {
                    if(maxLen < (i - stack.peek()))
                        maxLen = i - stack.peek();
                }
                else {
                    stack.push(i);
                }
            }
        }

        return maxLen;
    }
}
```