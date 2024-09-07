https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

#### [Naive Approach] Iterating over all subarrays – O(n^2) Time and O(1) Space

* Generate all sub-arrays one by one and check the sum of each subarray.
* If the sum of the current subarray is equal to zero then update the maximum length accordingly

```java
import java.util.*;

class GfG {
  
    // Function to find the length of the 
    // largest subarray with sum 0
    static int maxLen(int arr[]) {
        
        int n = arr.length;
        
        // Initialize the result
        int max_len = 0;

        // Loop through each starting point
        for (int i = 0; i < n; i++) {
          
            // Initialize the current sum 
            // for this starting point
            int curr_sum = 0;

            // Try all subarrays starting from 'i'
            for (int j = i; j < n; j++) {
              
                // Add the current element to curr_sum
                curr_sum += arr[j];

                // If curr_sum becomes 0, update max_len if required
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));
    }
}
```

#### Using Hashmap and Prefix Sum

* Check if the current prefix sum has been seen before, it means a subarray with zero sum exists between the previous index (where this prefix sum was first seen) and the current index.
* Keep track of the maximum length of any zero-sum subarray found.

```java
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int maxLength = 0;
        
        Map<Integer, Integer> sumIndex = new HashMap<>();
        
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
            
            if(sum==0){
                maxLength = i+1;
            }
            
            if(sumIndex.containsKey(sum)){
                maxLength = Math.max(maxLength, i-sumIndex.get(sum));
            } else {
                sumIndex.put(sum, i);
            }
        }
        
        return maxLength;
    }
}
```

**Complexity :** O(n) Time and O(n) Space