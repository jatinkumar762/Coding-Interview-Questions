[Problem](https://leetcode.com/problems/find-pivot-index/)

#### Optimal Code
```java
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
```

#### Normal Code
```java
class Solution {
    public int pivotIndex(int[] nums) {
        
        int[] rightSumArr = new int[nums.length];

        int rightSum=0;
        for(int i=nums.length-1;i>=0;i--){
            rightSum+=nums[i];
            rightSumArr[i]=rightSum;
        }
        
        int leftSum=0;
        for(int i=0;i<nums.length;i++){
            leftSum+=nums[i];
            if(leftSum==rightSumArr[i])
                return i;
        }
        
        return -1;
    }
}
```