[Problem](https://leetcode.com/problems/longest-consecutive-sequence/)

#### Methods
* Sorting - O(NlogN)
* Hashing - O(N) - if Set takes O(1) for operation
* PriorityQueue - O(NlogN) - Time required to push and pop N elements is logN for each element.

##### Method: Sorting

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);// O(nlgn);

        int longest = 1;
        int currLongest = 1;
        int len = nums.length;

        for (int index = 1; index < len; index++) {

            if (nums[index] == nums[index - 1]) {
                continue;
            }

            if (nums[index] == nums[index - 1] + 1) {
                currLongest++;
            } else {
                currLongest = 1;
            }

            longest = longest > currLongest ? longest : currLongest;
        }

        return longest;
    }
}
```


##### Method: Hashing

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        int len = nums.length;

        for (int num : nums) {

            // check is this num can be starting point
            if (set.contains(num - 1)) {
                continue;
            }

            int currLongest = 1;
            int j = num + 1;
            while (set.contains(j)) {
                j++;
            }
            currLongest = j - num;

            longest = longest > currLongest ? longest : currLongest;
        }

        return longest;
    }
}
```



