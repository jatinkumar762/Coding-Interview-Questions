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
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int res = q1.remove();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.size() == 0;
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

 ### Follow-up: Can you implement the stack using only one queue?

[Implement a stack using single queue](https://www.geeksforgeeks.org/implement-a-stack-using-single-queue/)

* Push - $O(N)$
* Pop - $O(1)$
* invert the order of queue elements when pushing a new element

```java
class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {

        int size = queue.size();

        queue.add(x);

        for (int i = 0; i < size; i++) {
            int tmp = queue.remove();
            queue.add(tmp);
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
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