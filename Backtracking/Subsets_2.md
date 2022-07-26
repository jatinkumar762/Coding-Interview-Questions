[Problem](https://leetcode.com/problems/subsets-ii/)

```java
class Solution {

    Set<List<Integer>> result = new HashSet<>();
    public void getSubSets(int[] nums, int start,int end, List<Integer> data)
    {
            if(start>=end){
                List<Integer> tmp=new ArrayList<Integer>();
                tmp.addAll(data);
                //Collections.sort(tmp);
                result.add(tmp);
                return;
            }
        
            
           getSubSets(nums, start+1, end, data); 

           data.add(nums[start]);

           getSubSets(nums, start+1, end, data); 

           data.remove(data.size()-1);
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) { 
        
        Arrays.sort(nums);
        
        getSubSets(nums, 0, nums.length, new ArrayList<Integer>());
        
        return result.stream().collect(Collectors.toList());
    }
}
```