[The Celebrity Problem](https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1)

#### Method-1: Graph Concept
* two arrays indegree and outdegree, to store the indegree and outdegree
* Run a nested loop, the outer loop from 0 to n and inner loop from 0 to n.
* For every pair i, j check if i knows j then increase the outdegree of i and indegree of j
* For every pair i, j check if j knows i then increase the outdegree of j and indegree of i
* Run a loop from 0 to n and find the id where the indegree is n-1 and outdegree is 0

Time Complexity: O(n2). 
  A nested loop is run traversing the array, So the time complexity is O(n2)
Space Complexity: O(n). 
  Since extra space of size n is required.


#### Method-2: Uses elimination technique 

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

Time Complexity: O(n). 
  The total number of comparisons 3(N-1), so the time complexity is O(n).
Space Complexity: O(n). 
  n extra space is needed to store the stack.

#### Method-3: Uses elimination technique





#### References:
* [https://www.geeksforgeeks.org/the-celebrity-problem/](https://www.geeksforgeeks.org/the-celebrity-problem/)