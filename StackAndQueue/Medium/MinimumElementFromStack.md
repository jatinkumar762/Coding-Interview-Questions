[Min Stack](https://leetcode.com/problems/min-stack/)

```java
class MinStack {

    Stack<Integer> stack;
    int min;
    LinkedList<Integer> minElement;

    public MinStack() {
        stack = new Stack<>(); 
        minElement = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min>val){
            min = val;
        }
        minElement.addFirst(min);
        stack.add(val);
    }
    
    public void pop() {
        minElement.remove();
        stack.pop();

        //very imp condition
        if(minElement.isEmpty()){
            min = Integer.MAX_VALUE;
        } else {
            min = minElement.get(0);
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minElement.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 ```

Case-1
["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
Output
[null,null,null,null,null,0,null,0,null,0,null,2]

Case-2
["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
Output
[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]

Case-3
["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
[[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
Output
[null,null,null,-10,-10,null,-20,-20,-20,-20,null,null,null,-10,null,null,-7,-10,null]


#### Editorial
* [https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/](https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/)