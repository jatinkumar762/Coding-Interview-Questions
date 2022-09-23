[Next Greater Element](https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1)

```java
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> stack = new Stack<Long>();
        
        long[] result = new long[n];
        
        long max=0;
        int i;
        for(i=arr.length-1;i>=0;i--)
        {
            while(!stack.empty() && arr[i]>=stack.peek())
            {
                stack.pop();
            }
            result[i]=stack.empty()?-1:stack.peek();
            stack.push(arr[i]);
        }
    
        return result;
    } 
}
```
