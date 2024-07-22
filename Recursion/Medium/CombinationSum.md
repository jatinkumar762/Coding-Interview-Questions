* https://leetcode.com/problems/combination-sum/description/

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    int N;

    private void findCombinationSum(int start, int[] candidates, int target, List<Integer> tmp) {

        if (target < 0)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < N; i++) {
            if (target >= candidates[i]) {
                tmp.add(candidates[i]);
                findCombinationSum(i, candidates, target - candidates[i], tmp);
                tmp.remove(tmp.size() - 1);
            } 
            // else { when array is sorted, can use this
            //     break;
            // }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        N = candidates.length;
        //Arrays.sort(candidates);
        findCombinationSum(0, candidates, target, new ArrayList<>());
        return result;
    }
}
```