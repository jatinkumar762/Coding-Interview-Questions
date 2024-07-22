https://leetcode.com/problems/permutations/description/

#### Approach-1 taking 0ms time

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    int N;

    private void findPermute(int index, int[] nums) {

        /*
        bcz of this - taking so much time
        if (index == N) {
            result.add(convertToList(nums));
            return;
        }
        */
        if (index == N) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            result.add(ds);
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

#### Approach-2 