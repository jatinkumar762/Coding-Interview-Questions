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

https://leetcode.com/problems/next-greater-element-i/

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> numToMax = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                stack.push(nums2[i]);
                numToMax.put(nums2[i], -1);
            } else {
                numToMax.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
        }

        int[] res = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            res[i] = numToMax.get(nums1[i]);
        }

        return res;
    }
}
```
