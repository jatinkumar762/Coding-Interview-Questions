https://www.geeksforgeeks.org/problems/rotation4723/1

* min element index position can determine no of rotations 

```java
class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int left = 0;
        int right = arr.size() - 1;
        int mid = left + (right-left)/2;
        
        while(left<=right){
            
            // The current subarray is already sorted,
            // the minimum is at the low index
            if(arr.get(left)<=arr.get(right)){
                return left;
            }
            
            mid = left + (right-left)/2;
            
            if(arr.get(mid)>arr.get(right)){
                // The right half is not sorted. So
                // the minimum element must be in the
                // right half.
                left = mid +1;
            } else {
                
                // The right half is sorted. Note that in
                // this case, we do not change high to mid - 1
                // but keep it to mid. The mid element
                // itself can be the smallest
                right = mid;
            }
        }
        
         return mid; //arr[left] will also work
    }
}
```