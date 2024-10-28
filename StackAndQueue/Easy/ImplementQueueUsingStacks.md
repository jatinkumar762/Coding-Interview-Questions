[Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

#### Approach: 1 (Two Stacks) Push - O(1) per operation, Pop - Amortized O(1) per operation.

```java
class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(!s2.isEmpty())
            return s2.pop();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.isEmpty())
            return s2.peek();
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 ```

 **Note: Amortized Analysis**

The transfer from stack1 to stack2 happens at most once for each element throughout the sequence of operations, leading to the $O(n)$ total time for n operations. Thus, each operation is $O(1)$ on average.


**Amortized analysis** is a technique used in computer science to analyze the average time complexity of operations over a sequence of operations, rather than looking at the worst-case time complexity of individual operations