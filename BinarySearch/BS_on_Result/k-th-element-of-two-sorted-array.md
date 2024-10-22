https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

```java
class Solution {
    public long kthElement(int k, int nums1[], int nums2[]) {
        // code here
        int len1 = nums1.length;
        int len2 = nums2.length;

        int index1 = 0, index2 = 0, index3 = 1;
        
        //in our case index starts from 0
        //but kth element means from 1
        //so we started index3 count from 1
        //no issue will happen, bcz not storing in arr
        
        while (index1 < len1 && index2 < len2) {

            if (nums1[index1] <= nums2[index2]) {

                if (index3 ==  k) {
                    return (long)nums1[index1];
                }
                
                index1++;
            } else {

                if (index3 == k) {
                    return (long)nums2[index2];
                }

                index2++;
            }

            index3++;
        }

        while (index1 < len1) {
           if (index3 ==  k) {
                return (long)nums1[index1];
            }

            index1++;
            index3++;
        }

        while (index2 < len2) {
            if (index3 == k) {
                return (long)nums2[index2];
            }
            index2++;
            index3++;
        }

        return -1L;
    }
}
```