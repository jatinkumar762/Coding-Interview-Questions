https://www.geeksforgeeks.org/problems/geeks-training/1


#### Recursive Solution - TLE

```java
class Solution {
    
    public int maximumPoints(int arr[][], int N) {
        // code here
        
        return calMaxMeritPoint(arr, N-1, -1, 0);
    }
    
    private int calMaxMeritPoint(int arr[][], int index, int prevSelected, int sum){
        
        int max = Integer.MIN_VALUE, tmp = 0;;
        
        if(index==0) {
            for(int i=0;i<3;i++){
                if(i!=prevSelected){
                    tmp = sum + arr[index][i];
                }
                max = max > tmp ? max : tmp;
            }
            return max;
        }
        
        
        for(int i=0; i<3 ; i++){
            
            if(i!=prevSelected){
                tmp = calMaxMeritPoint(arr, index-1, i, sum + arr[index][i]);
            }
            
            max = max > tmp ? max : tmp;
        }
        return max;
    }
}
```

### Top-Down Approach (Memorization)

index - day
prevSelected - activity

we will need 2D array

* above recursive, function we need to modify &rarr; otherwise wrong intermediatory result will get stored 

n=3 and arr[]= [[1,2,5],[3,1,1],[3,3,3]]

                                        DAY    ACTIVITY
                                          f(2, 3)

              f(1, 0)                     f(1, 1)                   f(1, 2)

      f(0, 1)         f(0, 2)      f(0, 0)       f(0, 2)    f(0, 0)        f(0, 1)


```java
class Solution {
    
    int[][] dp;
    
    public int maximumPoints(int arr[][], int N) {
        // code here
        
        dp = new int[N][4];
        
        for(int[] day : dp){
            Arrays.fill(day, -1);
        }
        
        //instead of -1, we are using 3 
        //so that we can store res inside d[index][3]
        return calMaxMeritPoint(arr, N-1, 3);
    }
    
    private int calMaxMeritPoint(int arr[][], int index, int prevSelected){
        
        int max = Integer.MIN_VALUE, tmp = 0;;
        
        if(index==0) {
            for(int i=0;i<3;i++){
                if(i!=prevSelected){
                    tmp = arr[index][i];
                }
                max = max > tmp ? max : tmp;
            }
            
            return dp[index][prevSelected] = max;
        }
        
        if(dp[index][prevSelected]!=-1){
            return dp[index][prevSelected];
        }
        
        for(int i=0; i<3 ; i++){
            
            if(i!=prevSelected){
                tmp = arr[index][i] + calMaxMeritPoint(arr, index-1, i);
            }
            
            max = max > tmp ? max : tmp;
        }
        
        return dp[index][prevSelected] = max;
    }
}
```

**Time Complexity:**

* in worst case, there can be O(N*4) states &rarr; means f(index, lastActivity)

  - at each stage we are doing $O(3) work

* so time complexity &rarr; $O((N*4)*3) 

**Space Complexity:**

* O(N) - Recursion Stack 
* O(N*4) - dp
* total &rarr; $O(4N) + O(N)$ &rarr; $O(N)$

### Bottom-Up Approach

