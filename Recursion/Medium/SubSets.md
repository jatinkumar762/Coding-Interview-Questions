https://leetcode.com/problems/subsets/description/

#### Approach 2: Backtracking

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

