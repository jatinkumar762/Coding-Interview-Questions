https://leetcode.com/problems/single-element-in-a-sorted-array/description/

#### Approach-1 Using Bitwise XOR – O(N) Time and O(1) Space

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res = res^num;
        }

        return res;
    }
}
```

#### Approach-2 Using Binary Search – O(logN) Time and O(1) Space:

1. All elements before the single element that occurs 
  * have the first occurrence at even index (0, 2, ..) 
  * and the next occurrence at odd index (1, 3, …). 
2. And all elements after the single element that occurs 
  * once have the first occurrence at an odd index 
  * and the next occurrence at an even index. 


&rarr; from observation we can say, that single element will always be on even index

nums &rarr;    1 1 2 2 3 5 5 6 6

index &rarr;   0 1 2 3 4 5 6 7 8

single element occurring at index-4 even index

before index-4 -> first occurrence at even index then odd index
after index-4 -> first occurrence at odd index then even


```java
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int end = nums.length - 1;
        int start = 0;
        int mid;

        while (start < end) {
            mid = start + (end - start) / 2;

            if ((mid & 1) == 0) { // even index

                if (nums[mid] == nums[mid + 1]) {
                  //exist in first part
                    start = mid + 2;
                } else {
                  //exist in second part
                  //this index can also be result - even index
                    end = mid;
                }

            } else {

                if (nums[mid] == nums[mid - 1]) {
                  //exist in first part
                    start = mid + 1;
                } else {
                  //exist in second part
                    end = mid - 1;
                  //why mid-1, bcz our single element is on even index
                  //we can shorter
                }
            }
        }

        // when start==end, exit from while
        return nums[start];
    }
}
```




