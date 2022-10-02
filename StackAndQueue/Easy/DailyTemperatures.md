[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

```java
class Solution {
    
    class Node{
        int val;
        int index;
        Node(int v,int i){
            this.val = v;
            this.index = i;
        }
    }
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Node> stack = new Stack<Node>();
        
        int N = temperatures.length;
        int[] result = new int[N];
        
        result[N-1] = 0;
        stack.push(new Node(temperatures[N-1], N-1));
        
        for(int i=N-2;i>=0;i--){
            while(stack.size()>0 && stack.peek().val<=temperatures[i]){
                stack.pop();
            }
            if(stack.size()==0){
                result[i] = 0;
                stack.push(new Node(temperatures[i], i));
            } else {
                Node tmp = stack.peek();
                result[i] = tmp.index - i;
                stack.push(new Node(temperatures[i], i));
            }
        }
        return result;
    }
}
```