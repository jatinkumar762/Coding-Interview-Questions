[Problem](https://leetcode.com/problems/combination-sum-ii/)

```java
class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    public void getCombSum(int[] nums, int start, int target, List<Integer> data)
    {
            
            if(target<0)
                return;
        
            if(target==0){
                List<Integer> tmp=new ArrayList<Integer>();
                tmp.addAll(data);
                result.add(tmp);
                return;
            }
        
            for(int i=start;i<nums.length;i++){
               data.add(nums[i]);
               if(i>start && nums[i]==nums[i-1]){
                 data.remove(data.size()-1);
                 continue;
               }
               getCombSum(nums, i+1, target-nums[i], data); 
               data.remove(data.size()-1);
            }
        
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        getCombSum(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
}
```