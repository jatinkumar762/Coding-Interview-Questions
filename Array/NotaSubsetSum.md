[Not a subset sum](https://practice.geeksforgeeks.org/problems/smallest-number-subset1220/1)

```java
class Solution {
    long findSmallest(long[] arr, int n) {
        // code here
        long res = 1; // Initialize result
 
        // sort the input array
        Arrays.sort(arr);
       
        // Traverse the array and increment 'res' if arr[i] is
        // smaller than or equal to 'res'.
        for (int i = 0; i < n; i++)
        {
          if(arr[i] > res){
            return res;
           }
          else{
            res+=arr[i];
          }
        }
             
        return res;
    }
}
```

#### Editorial
* [https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/](https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/)