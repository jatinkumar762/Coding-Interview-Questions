1. https://www.youtube.com/watch?v=fFVZt-6sgyo
2. https://leetcode.com/problems/subarray-sum-equals-k/description/

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        HashMap<Integer, Integer> sumToCountMap = new HashMap<Integer, Integer>(); 
        //remove empty prefix
        sumToCountMap.put(0,1);
        int sum=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sumToCountMap.containsKey(sum-k)){
                count+= sumToCountMap.get(sum-k);
            }
            sumToCountMap.put(sum, sumToCountMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
```