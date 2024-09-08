https://leetcode.com/problems/merge-sorted-array/description/

#### Optimal Approach - $O(N)$ time; $O(1)$ space &rarr; 0ms

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int totalIndex = m + n - 1;
        int i1 = m - 1, i2 = n - 1;

        while (i1 >= 0 && i2 >= 0) {

            if (nums1[i1] > nums2[i2]) {
                nums1[totalIndex--] = nums1[i1--];
            } else {
                nums1[totalIndex--] = nums2[i2--];
            }
        }

        while (i1 >= 0) {
            nums1[totalIndex--] = nums1[i1--];
        }

        while (i2 >= 0) {
            nums1[totalIndex--] = nums2[i2--];
        }

    }
}
```

#### Sorting - Slower approach - $O(NLogN)$ time; $O(1)$ space 

* put nums2 elements also in num1
* sort the array

#### Extra Space - $O(N)$ time; $O(N)$ space 

* here N = m+n