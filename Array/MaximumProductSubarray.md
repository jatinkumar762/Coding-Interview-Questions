[Problem](https://leetcode.com/problems/maximum-product-subarray/)

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