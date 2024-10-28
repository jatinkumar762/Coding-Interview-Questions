https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1

```java
class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;
    
    // Function to push an integer into the stack.
    void push(int a) {
        
        StackNode tmp = new StackNode(a);
        
        //will handle case when top == null
        tmp.next = top;
        
        top = tmp;
    }

    // Function to remove an item from top of the stack.
    int pop() {

        if(top==null){
            return -1;
        }
        
        int tmp = top.data;
        
        top = top.next;
        
        return tmp;
    }
}
```