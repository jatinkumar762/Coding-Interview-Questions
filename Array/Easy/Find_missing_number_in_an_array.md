https://leetcode.com/problems/missing-number/description/

#### Approach-1: SUM

```java
class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;

        int total = (n * (n + 1)) / 2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return total-sum;
    }
}
```

#### Approach-2: XOR

**Note:**

1. XOR of two same numbers is always 0 i.e. a ^ a = 0. 
2. XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.

**Example:**

```
Assume the given array is: {1, 2, 4, 5} and N = 5.
XOR of (1 to 5) i.e. xor1 = (1^2^3^4^5)
XOR of array elements i.e. xor2 = (1^2^4^5)
XOR of xor1 and xor2 = (1^2^3^4^5) ^ (1^2^4^5)
			= (1^1)^(2^2)^(3)^(4^4)^(5^5)
			= 0^0^3^0^0 = 0^3 = 3.
The missing number is 3.
```

```java
public int missingNumber(int[] nums) { //xor
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
    }
    return res;
}
```