[Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)

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
        if(s2.size()>0)
            return s2.pop();
        while(s1.size()>0){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.size()>0)
            return s2.peek();
        while(s1.size()>0){
            s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.size()==0 && s2.size()==0;
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