[Problem](https://practice.geeksforgeeks.org/problems/minimum-swaps/1)

```java
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        Map<Integer,Integer> valToIndex = new HashMap<>();
        for(int i=0;i<tmp.length;i++){
            valToIndex.put(tmp[i],i);
        }
        int ans = 0;
        boolean[] visited = new boolean[nums.length];
        
        for(int i=0;i<nums.length;i++){
            
            if(visited[i]||valToIndex.get(nums[i])==i){
                
            } else {
                visited[i] = true;
                int correctIndex = valToIndex.get(nums[i]);
                while(correctIndex!=i){
                    visited[correctIndex] = true;
                    ans+=1;
                    correctIndex = valToIndex.get(nums[correctIndex]);
                }
            }
        }
        return ans;
    }
}
```

#### Editorial
* [https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/](https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/)
* [https://www.geeksforgeeks.org/minimum-number-of-swaps-required-to-sort-an-array-set-2/](https://www.geeksforgeeks.org/minimum-number-of-swaps-required-to-sort-an-array-set-2/)