https://leetcode.com/problems/subarray-sum-equals-k/description/

#### Approach-1 Using HashSet and Prefix Sum 

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

#### Approach-2 Naive O(n^2) time 


* https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/