[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int n1 = m-1;
        int n2 = n-1;
        int r = m+n-1;
        
        for(;r>=0;r--) {
            if(n1>=0 && n2>=0){
                nums1[r] = nums1[n1]>nums2[n2]?nums1[n1--]:nums2[n2--];
            } else if(n1>=0){
                nums1[r] = nums1[n1--];
            } else {
                nums1[r] = nums2[n2--];
            }
        }
        
    }
}
```