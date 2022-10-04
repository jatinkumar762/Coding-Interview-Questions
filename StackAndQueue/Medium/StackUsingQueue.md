[Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

```java
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    public int pop() {
        while(q1.size()>1){
            top = q1.remove();
            q2.add(top);
        }
        int res = q1.remove();
        q1 = q2;
        q2 = new LinkedList<Integer>();
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.size()==0 && q2.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
 ```

 #### Follow-up: Can you implement the stack using only one queue?
 * Push - O(N)
 * Pop - o(1)
 * invert the order of queue elements when pushing a new element