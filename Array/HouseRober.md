[Problem](https://leetcode.com/problems/house-robber/)

```java
class Solution {
    public int rob(int[] nums) {
        
        int[] arr = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i];
            
            int max = Integer.MIN_VALUE;
            for(int j=i-2;j>=0;j--){
                if(arr[j]>max){
                    max=arr[j];
                }
            }
            if(arr[i]+max>arr[i])
                arr[i]=arr[i]+max;
            
            if(res<arr[i])
                res = arr[i];
        }
        
        /*
            nums    ->  5 3 4 5
            arr     ->  5 3 9 10
        */
        
        return res;
    }
}
```