https://leetcode.com/problems/next-permutation/description/

```java
class Solution {

    // [2, 3, 1, 0] -> [3, 0, 1, 2]
    // [2, 1, 4, 3] -> [2, 3, 1, 4]
    // [4,2,0,2,3,2,0] -> [4,2,0,3,0,2,2]
    // [1,3,2] -> [2,1,3]
    public void nextPermutation(int[] nums) {

        int n = nums.length, j = 0, k = 0;
        boolean found = false;

        for (j = n - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) {
                break;
            }
        }

        if (j == -1) {
            // Arrays.sort(nums);

            // array is in descending order - just reverse the array
            // reverse will take less time
            reverse(nums, 0, n - 1);
            return;
        }

        // find next min

        /* below code will take less comparison
        int minIndex = j + 1;
        for (k = j + 1; k < n; k++) {
            if (nums[k] > nums[j] && nums[k] < nums[minIndex]) {
                minIndex = k;
            }
        }
        */

        // bcz from j+1 to n -> array is in descending order
        for (k = n - 1; k > j; k--) {
            if (nums[k] > nums[j]) {
                break;
            }
        }

        // System.out.println(j + " " + minIndex);

        swap(nums, j, k);

        // Arrays.sort(nums, j + 1, n);
        reverse(nums, j + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int a[], int low, int high) {
        while (low < high) {
            swap(a, low, high);
            low++;
            high--;
        }
    }
}
```
![Test case](../images/NextPermutation.png)

**Wrong Approach**

```java
class Solution {

    // [2, 3, 1, 0] -> [3, 0, 1, 2]
    // [2, 1, 4, 3] -> [2, 3, 1, 4]
    // [4,2,0,2,3,2,0] -> [4,2,0,3,0,2,2]
    public void nextPermutation(int[] nums) {

        int n = nums.length, i=0, j=0;
        boolean found = false;

        for (i = n - 1; i >= 1; i--) {
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;

                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (found) {
            Arrays.sort(nums, j + 1, n);
        } else {
            Arrays.sort(nums);
        }
    }
}
```


