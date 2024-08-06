https://leetcode.com/problems/next-greater-element-ii/description/

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int N = nums.length;

        int[] res = new int[N];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
       

        for(int i=2*N-1; i>=0; i--){
            
            while(!stack.isEmpty() && stack.peek() <= nums[i%N] ){
                stack.pop();
            }

            if(!stack.isEmpty()){
                //duplicate possible
                //based on index storing corresponding result
                res[i%N] = stack.peek();
            }

            stack.push(nums[i%N]);
        }
        return res;
    }
}
```