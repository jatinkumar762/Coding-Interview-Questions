https://leetcode.com/problems/combination-sum-iii/description/

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    int N = 9;
    int K;

    private void findCombinationSum(int start, int target, List<Integer> tmp) {

        if (target < 0 || (tmp.size() > K))
            return;

        if (target == 0) {
            if (tmp.size() == K) {
                result.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            tmp.add(i);
            findCombinationSum(i + 1, target - i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        K = k;
        findCombinationSum(1, n, new ArrayList<>());
        return result;
    }
}
```