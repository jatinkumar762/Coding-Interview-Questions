[The Celebrity Problem](https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1)

```java
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    boolean knows(int M[][], int a,int b){
        if(M[a][b]==1)
            return true;
        return false;
    }
    
    int celebrity(int M[][], int n)
    {
    	// code here
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i=0;i<n;i++)
    	    stack.push(i);
    	
    	while(stack.size()>1){
    	    int a = stack.pop();
    	    int b = stack.pop();
    	    
    	    if(knows(M, a, b)){
    	        stack.push(b);
    	    } else
    	        stack.push(a);
    	}
    	
    	int celebrity = stack.pop();
    	
    	for(int i=0;i<n;i++){
    	    if(i!=celebrity && (!knows(M, i, celebrity) || knows(M, celebrity, i))){
    	        return -1;
    	    }
    	}
    	return celebrity;
    }
}
```