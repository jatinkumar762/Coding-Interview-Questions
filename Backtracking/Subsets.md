[Problem](https://leetcode.com/problems/subsets/)

```java
class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    public void getSubSets(int[] nums, int start,int end, List<Integer> data)
    {
            if(start>=end){
                List<Integer> tmp=new ArrayList<Integer>();
                tmp.addAll(data);
                result.add(tmp);
                return;
            }
        
            
           getSubSets(nums, start+1, end, data); 

           data.add(nums[start]);

           getSubSets(nums, start+1, end, data); 

           data.remove(data.size()-1);
        
    }
    
    public List<List<Integer>> subsets(int[] nums) { 
        getSubSets(nums, 0, nums.length, new ArrayList<Integer>());
        return result;
    }
}
```