https://leetcode.com/problems/subsets-ii/description/

#### Approach-1 Optimized Solution

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private int N;

    private void calSubSet(int index, int[] nums, List<Integer> tmp) {

        // if (index == N) {
        result.add(new ArrayList<>(tmp));
        // return;
        // }

        for (int i = index; i < N; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            calSubSet(i + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }

        // calSubSet(index + 1, nums, tmp);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        N = nums.length;
        Arrays.sort(nums);
        calSubSet(0, nums, new ArrayList<>());
        return result;
    }
}
```

#### Approach-2 Non Optimized

```java
class Solution {

    private Set<List<Integer>> result = new HashSet<>();
    private int N;

    private void calSubSet(int index, int[] nums, List<Integer> tmp) {

        if (index == N) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        // for (int i = index; i < N; i++) {
        // if (i != index && (nums[i] == nums[i - 1])) {
        // continue;
        // }
        // tmp.add(nums[index]);
        // calSubSet(i + 1, nums, tmp);
        // tmp.remove(tmp.size() - 1);
        // }
        tmp.add(nums[index]);
        calSubSet(index + 1, nums, tmp);
        tmp.remove(tmp.size() - 1);
        calSubSet(index + 1, nums, tmp);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        N = nums.length;
        Arrays.sort(nums);
        calSubSet(0, nums, new ArrayList<>());
        return new ArrayList<>(result);
    }
}
```