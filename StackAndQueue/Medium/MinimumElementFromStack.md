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

#### Editorial
* [https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/](https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/)