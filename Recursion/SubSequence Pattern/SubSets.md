https://leetcode.com/problems/subsets/description/

### Approach 1: Recursive

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private int N;

    private void findAllSubSets(int index, int[] nums, List<Integer> tmp){

        if(index == N){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }

        tmp.add(nums[index]);

        findAllSubSets(index+1, nums, tmp);

        tmp.remove(tmp.size()-1);

        findAllSubSets(index+1, nums, tmp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        N = nums.length;

        findAllSubSets(0, nums, new ArrayList<>());

        return result;
    }
}
```

**TimeComplexity:** $O(2^N)$ at each index we have 2 choices to take or not-take

**SpaceComplexity:** $O(N)$

### Approach 2: Recursive

```java
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int windowSize, N;
    
    public void generateAllSubSet(int[] nums, int start, List<Integer> tmp){

        if(tmp.size() == windowSize){
            //very imp to create new
            //otherwise balnk will create
            result.add(new ArrayList(tmp));
            return;
        }

        for(int i = start;i<N;i++){     
            tmp.add(nums[i]);
            generateAllSubSet(nums, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        N = nums.length;
        for(windowSize=0;windowSize<=nums.length;windowSize++) {
            generateAllSubSet(nums, 0, new ArrayList<>());
        }
        return result;
    }
}
```

TimeComplexity - O(N×2^N) to generate all subsets and then copy them into the output list.
Each element has 2 possibilities to take or not

#### Approach 3: Binary String

