[Problem](https://leetcode.com/problems/combination-sum/)

```java
class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    public void getCombSum(int[] nums, int start, int target, List<Integer> data)
    {
            
            if(target<0 || (start==nums.length))
                return;
        
            if(target==0){
                List<Integer> tmp=new ArrayList<Integer>();
                tmp.addAll(data);
                result.add(tmp);
                return;
            }
        
            for(int i=start;i<nums.length;i++){
               data.add(nums[i]);
               getCombSum(nums, i, target-nums[i], data); 
               data.remove(data.size()-1);
            }
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getCombSum(candidates, 0, target, new ArrayList<Integer>());
        return result;
    }
}
```