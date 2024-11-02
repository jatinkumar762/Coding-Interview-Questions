https://leetcode.com/problems/sum-of-subarray-minimums/description/

### Approach-1 Brute Force 

```java
class Solution {

    int mod = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            int currMin = arr[i];
            for(int j = i + 1; j<arr.length; j++){
                currMin = currMin < arr[j] ? currMin : arr[j];
                sum = (sum + currMin) % mod;
            }
            sum = (sum + arr[i]) % mod; 
        }

        return sum;
    }
}
```

### Approach-2