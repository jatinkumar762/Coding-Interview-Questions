[Problem](https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1)

* Method-1: Recursive - O(N^N)
* Method-2: Dynamic Programming - O(N^2)
* Method-3: Linear Solution - O(N)
----

#### Method-3

```java
class Solution{
    static int minJumps(int[] nums){
        // your code here
        if(nums.length==1)
            return 0;
        
        int steps = nums[0];
        int maxReach = nums[0];
        int jump=1;
        
        if(steps==0)
            return -1;
                
        for(int i=1;i<nums.length;i++){
            
            if(i==nums.length-1)
                return jump;
            
            steps-=1;
            if(maxReach<nums[i]+i)
                maxReach = nums[i]+i;
            
            if(steps==0){
                steps = maxReach-i;
                jump+=1;
            }                
            
            if(steps<=0)
                return -1;
        }
        return jump;
    }
}
```

[Editorial](https://www.youtube.com/watch?v=_6QpiqTw_ew)