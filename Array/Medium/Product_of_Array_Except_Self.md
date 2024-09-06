[Problem](https://leetcode.com/problems/product-of-array-except-self/)

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] res = new int[nums.length];
        res[0] = 1;
        
        int left = 1;
        for(int i=1;i<nums.length;i++){
            left = left * nums[i-1];
            res[i] = left;
        }
        
        int right = 1;
        for(int i=nums.length-2;i>=0;i--){
            right = right * nums[i+1];
            res[i] = res[i] * right;
        }
        
        return res;
    }
}
```

#### Editorial
* [https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space](https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space)