https://www.interviewbit.com/problems/nearest-smaller-element/


```java
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        Stack<Integer> stack = new Stack<>();
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(Integer ele : A){
            
            while(!stack.isEmpty() && stack.peek() > ele){
                stack.pop();
            }
            
            int smaller = stack.isEmpty() ? -1 : stack.peek();
                        
            result.add(smaller);
            
            stack.add(ele);
        }
        
        return result;
    }
}
```