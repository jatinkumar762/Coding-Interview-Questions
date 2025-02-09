https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/


### Approach - 1

```java
class Solution {
    public int removeDuplicates(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return 1;
        }

        int start = 0, end = 1, count = 1;

        for (; end < length; end++) {

            if (nums[end] == nums[start]) {
                count++; // Increment count for the current element
            } else {
                count = 1; // Reset count for new element
            }

            if (count <= 2) {
                nums[++start] = nums[end]; // Update the array in place
            }
        }

        return start + 1;
    }
}
```

**Another way**

```java
class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 1; // Pointer to iterate through the array
        int j = 1; // Pointer to track position for valid elements
        int count = 1; // Count of occurrences of the current element

        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    i++;
                    continue;
                }
            } else {
                count = 1;
            }
            nums[j] = nums[i];
            j++;
            i++;
        }

        // Java arrays can't be resized like C++ vectors,
        // so we return the size directly.
        return j;
    }
}
```

**Time Complexity:** $O(N)$
