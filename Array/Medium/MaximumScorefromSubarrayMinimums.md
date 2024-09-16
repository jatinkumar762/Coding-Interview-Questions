https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0

#### Approach

* sum of smallest and second smallest numbers, max will only be possible if two neighbor sum is max 

arr[] = [4, 3, 1, 5, 6] &rarr; 11

arr[] = [5, 4, 3, 1, 6] &rarr; 9


```java
class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        
        // Your code goes here
        int maxSum = 0;
        int sum = 0;
        for(int i=1;i<arr.size();i++){
            sum = arr.get(i) + arr.get(i-1);
            maxSum = maxSum>sum?maxSum:sum;
        }
        return maxSum;
    }
}
```