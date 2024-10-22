https://leetcode.com/problems/median-of-two-sorted-arrays/description/


### Linear Merge Approach

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int len3 = len1 + len2;

        int[] nums3 = new int[len3];

        int index1 = 0, index2 = 0, index3 = 0;

        while (index1 < len1 && index2 < len2) {

            if (nums1[index1] <= nums2[index2]) {

                nums3[index3++] = nums1[index1];
                index1++;

            } else {

                nums3[index3++] = nums2[index2];
                index2++;
            }
        }

        while (index1 < len1) {
            nums3[index3++] = nums1[index1];
            index1++;
        }

        while (index2 < len2) {
            nums3[index3++] = nums2[index2];
            index2++;
        }

        if (len3 % 2 != 0) {
            return (double)nums3[len3 / 2];
        } else {
            return ((double)nums3[len3 / 2] + (double)nums3[len3/2 - 1]) / 2;
        }
    }
}
```