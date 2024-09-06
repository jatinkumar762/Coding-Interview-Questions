[Problem](https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1)

```java
class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        if(n==1)
            return 0;
            
        Map<Integer,Integer> keys = new HashMap<>();
        keys.put(arr[0], 1);
        
        //this logic will not work in case of duplicate
        int count = 0;
        for(int i=1;i<n;i++) {
            if(arr[i]<=k) { 
                if(keys.containsKey(k-arr[i])){
                    int freq = keys.get(k-arr[i]);
                    count+= freq;
                }
                if(keys.containsKey(arr[i])){
                   keys.put(arr[i], keys.get(arr[i])+1); 
                } else {
                    keys.put(arr[i], 1);
                }
            }
        }
        return count;
    }
}
```
#### Editorial
* [GFG](https://www.geeksforgeeks.org/count-pairs-with-given-sum/)

---

[Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/)

* Method-1 : Brute - O(N^2)
* Method-2 : Sorting - O(NLogN)
* Method-3 : Map - O(N)

##### Sorting Solution
```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == k) {
                count++;
                i++;
                j--;
            }
            else if(sum > k) j--;
            else i++;
        }
        return count;
    }
}
```

##### Map Solution
```java
class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int res = k - nums[i];
            if(map.containsKey(res)){
                count++;
                if(map.get(res) == 1) map.remove(res);
                else map.put(res, map.get(res) - 1);
            }
            else{
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}
```

#### Editorial
* [Leetcode Discuss](https://leetcode.com/problems/max-number-of-k-sum-pairs/discuss/2005922/Going-from-O(N2)-greater-O(NlogN)-greater-O(N)-%2B-MEME)

