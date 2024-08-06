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

```java
class Solution {
    // Function to find if there is a celebrity in the party or not.
    
    int[] inDegree;
    int[] outDegree;
    
    public int celebrity(int mat[][]) {
        // code here
        int N = mat.length;
        
        inDegree = new int[N];
        outDegree = new int[N];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i!=j && mat[i][j]==1){
                    inDegree[j]+=1;
                    outDegree[i]+=1;
                }
            }
        }
        
        for(int i=0;i<N;i++){
            if( inDegree[i]==(N-1) && outDegree[i]==0){
                return i;
            }
        }
        
        return -1;
    }
}
```

#### Method-2: Uses elimination technique 

* If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
* If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be celebrity.
* Repeat above two steps till there is only one person.
* Ensure the remained person is a celebrity. 

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

#### Method-3: Uses two-pointer approach

1. Create two indices i and j, where i = 0 and j = n-1
2. Run a loop until i is less than j.
3. Check if i knows j, then i can’t be a celebrity. so increment i, i.e. i++
4. Else j cannot be a celebrity, so decrement j, i.e. j–
5. Assign i as the celebrity candidate
6. Now at last check that whether the candidate is actually a celebrity by re-running a loop from 0 to n-1  and constantly checking that if the candidate knows a person or if there is a candidate who does not know the candidate, then we should return -1. else at the end of the loop, we can be sure that the candidate is actually a celebrity.

* Time Complexity: O(n)
* Space Complexity: O(1) No extra space is required.


#### References:
* [https://www.geeksforgeeks.org/the-celebrity-problem/](https://www.geeksforgeeks.org/the-celebrity-problem/)