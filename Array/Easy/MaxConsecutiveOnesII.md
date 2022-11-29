[Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/)

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int L=0,R=0;
        int Zeros=0;
        int result = Integer.MIN_VALUE;
        while(R<nums.length)
        {
            if(nums[R]==0){
                Zeros++;
            }
            if(Zeros==2)
            {
                if(result<(R-L)){
                    result = R-L;
                }
                while(L<R && nums[L]!=0){
                    L++;
                }
                if(nums[L]==0){
                    L++; Zeros--;
                }
            }
            R++;
        }
        if(result<(R-L)){
            result = R-L;
        }
        return result;
    }
}
```