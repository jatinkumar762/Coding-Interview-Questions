[Problem](https://leetcode.com/problems/longest-consecutive-sequence/)

#### Methods
* Sorting - O(NlogN)
* Hashing - O(N)
* PriorityQueue - O(NlogN) - Time required to push and pop N elements is logN for each element.

##### Method: Sorting

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);//O(nlgn);
        int curr = nums[0];
        int sum = 1;
        int ans = 1;
        for(int i = 1;i< nums.length;i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == curr + 1){
                curr++;
                sum++;
                ans = Math.max(ans,sum);
            }else{
                curr = nums[i];
                sum = 1;
            }
        }
        return ans;
    }
}
```


##### Method: Hashing

```java
class Solution {
    public int longestConsecutive(int[] arr) {
       Set<Integer> set = new HashSet<>();
	   for(int i : arr){
	       set.add(i);
	   }
	   int maxLen = 0;
	   for(Integer num : set){
	       //if num is starting element
	       if(!set.contains(num-1)){
	           int len = 1;
	           int next = num+1;
	           while(set.contains(next)){
	               len += 1;
	               next += 1;
	           }
	           maxLen = maxLen<len?len:maxLen;
	       }
	   }
	   return maxLen;
    }
}
```



