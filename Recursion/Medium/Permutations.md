https://leetcode.com/problems/permutations/description/

#### Approach-1 Non-Optimized

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    int N;

    private void findPermute(int index, int[] nums) {

        if (index == N) {
            result.add(convertToList(nums));
            return;
        }

        for (int i = index; i < N; i++) {

            swap(nums, i, index);

            findPermute(index + 1, nums);

            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private List<Integer> convertToList(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<List<Integer>> permute(int[] nums) {
        N = nums.length;
        findPermute(0, nums);
        return result;
    }
}
```