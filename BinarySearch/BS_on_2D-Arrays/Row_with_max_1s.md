https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1

### Approach-1 $(Rows * Cols)$

* traverse array row wise, and count 1 for each row

### Approach-2 - Binary Search

* first occurrence of 1 // floor(1) // ceil(0)

```java
class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int rows = arr.length;
        int cols = arr[0].length;

        int max = 0;
        int maxIndex = -1;

        for (int i = 0; i < rows; i++) {
            int first1Col = first1sIndexInCol(arr[i], cols);

            if (first1Col == -1) {
                continue;
            }

            if (max < (cols - first1Col)) {
                max = cols - first1Col;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private int first1sIndexInCol(int[] nums, int cols) {

        if (nums[0] == 1) {
            return 0;
        }

        int left = 0, mid = 0;
        int right = cols - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == 1 && (mid == 0 || nums[mid - 1] != 1)) {
                return mid;
            }

            if (mid > 0 && nums[mid - 1] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (nums[mid] != 1) {
            return -1;
        }

        return mid;
    }
}
```