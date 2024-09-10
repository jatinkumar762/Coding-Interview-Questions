https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

#### Approach-1 Using Hashing - Prefix Sum (Helpful when both -ve and +ve numbers present)

* The idea is base on the fact that if Sj – Si = k (where Si and Sj are prefix sums till index i and j respectively, and i < j), then the subarray between i+1 to j has k sum
* For example, [5, 2, -3, 4, 7] and k = 3. The value of S3 – S0 = 3, it means the subarray from index 1 to 3 has sum equals to 3. 
* So we mainly compute prefix sums in the array and store these prefix sums in a hash table. And check if current prefix sum – k is already present

```java
class Solution{
    
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        int longest = 0;
        
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        
        int sum=0;
        for(int i=0;i<N;i++) {
            sum+=A[i];
            
            if(sum == K){
                longest = i+1; 
            }
            else if(sumIndexMap.containsKey(sum-K)){
                longest = Math.max(longest, i-sumIndexMap.get(sum-K));
            }
            
            if(!sumIndexMap.containsKey(sum)) { 
                sumIndexMap.put(sum, i); 
            }
            
        }
        return longest;
    }
}
```

#### Approach-2 Using 2 pointers (if only +ve numbers present)

* sliding window

```java
import java.util.*;

public class Main {
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}
```