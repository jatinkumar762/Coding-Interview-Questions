https://www.geeksforgeeks.org/problems/implement-stack-using-array/1

```java
class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        arr[++top] = x;
    }

    public int pop() {
        // Your Code
        if(top<0){
            return -1;
        }
        return arr[top--];
    }
}
```