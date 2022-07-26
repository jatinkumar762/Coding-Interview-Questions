[Problem](https://leetcode.com/problems/permutations-ii/)

```java
class Solution {
    
    Set<List<Integer>> result = new HashSet<>();
    
    public void nextCombination(int[] nums, int start, int end){
        
        if(start>=end){
            ArrayList<Integer> subResult = new ArrayList<Integer>();
            for(int e:nums){
                subResult.add(e);
            }
            result.add(subResult);
        }
        
        for(int i=start;i<nums.length;i++){
            int tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
            
            nextCombination(nums, start+1, end);
            
            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
        }
        
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int start=0;
        for(int i=start;i<nums.length;i++){
            int tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
            
            nextCombination(nums, start+1, nums.length);
            
            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
        }
        return result.stream().collect(Collectors.toList());
    }
}
```