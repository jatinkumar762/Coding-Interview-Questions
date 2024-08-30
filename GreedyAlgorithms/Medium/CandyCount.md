https://leetcode.com/problems/candy/description/

https://www.geeksforgeeks.org/problems/candy/1


#### Approach

1. we can create leftMax[] and rightMax[] array
2. initially all child will have 1 candies
3. leftMax will check -> current child from its left child
4. rightMax will check -> current child from its right child
5. res[] array will be max of (left[i], right[i])

**more optimized**

&rarr; we can use single array, instead of leftMax and rightMax arr



```java
class Solution {
    public int candy(int[] ratings) {
        
        int N = ratings.length;

        int[] candies = new int[N];
        Arrays.fill(candies, 1);
             
        //we need to check both left and right neighbour of current child
        
        //first we do left to right traversal
        //check for left child of current child
        
        for(int i=1;i<N;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        
        //now will do right to left traversal
        //check for right child of current child
        
        for(int i=N-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        
        int totalCandies = 0;
        
        for(int count : candies){
            totalCandies+=count;
        }
        
        return totalCandies;
    }
}
```
