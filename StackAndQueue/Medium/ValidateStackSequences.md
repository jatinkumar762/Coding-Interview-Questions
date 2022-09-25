[Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/)

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int i=0,j=0;
        int popLen = popped.length;
        int pushLen = pushed.length;
        
        for(i=0;i<pushLen;i++){
            stack.push(pushed[i]);
            while(stack.size()>0 && j<popLen && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        
        while(stack.size()>0 && j<popLen && stack.peek()==popped[j]){
            stack.pop();
            j++;
        }
        
        if(j==popLen)
            return true;
        return false;
    }
}
```