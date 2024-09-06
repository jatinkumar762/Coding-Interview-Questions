[Problem](https://leetcode.com/problems/maximum-product-subarray/)

#### Method-1: Using Min and Max variable

```java
class Solution {
    public int maxProduct(int[] arr) {
        int result = arr[0];
        int maxResult = arr[0];
        int minResult = arr[0];
        
        for(int i=1;i<arr.length;i++){
            
            if(arr[i]<0){
                int tmp = maxResult;
                maxResult = minResult;
                minResult = tmp;
            }
            
            if(maxResult*arr[i] < arr[i])
                maxResult = arr[i];
            else
                maxResult = maxResult*arr[i];
            
            if(minResult*arr[i] > arr[i])
                minResult = arr[i];
            else
                minResult = minResult*arr[i];
            
            if(result<maxResult){
                result = maxResult;
            }
        }
        return result;
    }
}
```

#### Method-2: 2-iterations

```java
class Solution {
    public int maxProduct(int[] nums) {
        
        int res = 1;
        int maxRes = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            res = res*nums[i];
            if(maxRes<res){
                maxRes = res;
            }
            if(res==0)
                res=1;
        }
        res=1;
        for(int i=nums.length-1;i>=0;i--){
            res = res*nums[i];
            if(maxRes<res){
                maxRes = res;
            }
            if(res==0)
                res=1;
        }
        return maxRes;
    }
}
```

* Note: Method-2 is faster than Method-1