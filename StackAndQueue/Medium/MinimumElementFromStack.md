[Get minimum element from stack](https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1)

```java
class GfG
{
    class Node {
        int val;
        int min;
        
        Node(int v,int m) {
            this.val = v;
            this.min = m;
        }
    }
    
    int minEle;
    Stack<Node> s = new Stack<Node>();

    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	    if(s.size()==0)
	        return -1;
	    return s.peek().min;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here
	    if(s.size()==0)
	        return -1;
	    return s.pop().val;
    }

    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here
	    if(s.size()==0){
	        s.push(new Node(x,x));
	    } else {
	        int min = s.peek().min>x?x:s.peek().min;
	        s.push(new Node(x,min));
	    }
    }	
}
```
---

[Min Stack](https://leetcode.com/problems/min-stack/)

```java
class MinStack {

    ArrayList<Integer> stack;
    ArrayList<Integer> stackMin;
    int top;
    int min;
    
    public MinStack() {
        stack = new ArrayList<Integer>();
        stackMin = new ArrayList<Integer>();
        top = -1;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        top+=1;
        stack.add(val); 
        if(val<min) {
            min = val;
        }
        stackMin.add(min);
    }
    
    public void pop() {
        stack.remove(top);
        stackMin.remove(top);
        top--;
        if(top>=0)
            min = stackMin.get(top);
        else
            min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return stackMin.get(top);
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

#### Editorial
* [https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/](https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/)