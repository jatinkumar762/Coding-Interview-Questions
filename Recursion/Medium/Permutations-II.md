https://leetcode.com/problems/permutations-ii/

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    int N;
    boolean[] used;

    private void findPermute(int index, int[] nums, List<Integer> tmp) {

        if (index == N) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i])
                continue;

            tmp.add(nums[i]);
            used[i] = true;
            findPermute(index + 1, nums, tmp);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        N = nums.length;
        used = new boolean[N];
        findPermute(0, nums, new ArrayList<>());
        return result;
    }
}
```