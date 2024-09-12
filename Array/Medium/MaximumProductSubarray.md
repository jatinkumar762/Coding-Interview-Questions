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

* if no of negative elements is even -> multiplication of all numbers will be +ve
    - multiplication of two -ve numbers always +ve
* if no of negative elements is odd -> multiplication of all numbers will be -ve
* if any number is 0, then product will become 0




```java
class Solution {
    public int maxProduct(int[] nums) {

        int product = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            if (maxProduct < product) {
                maxProduct = product;
            }
            if (product == 0)
                product = 1;
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            product = product * nums[i];
            if (maxProduct < product) {
                maxProduct = product;
            }
            if (product == 0)
                product = 1;
        }
        return maxProduct;
    }
}
```

* Note: Method-2 is faster than Method-1