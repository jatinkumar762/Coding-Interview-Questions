* https://www.naukri.com/code360/problems/aggressive-cows_1082559
* https://www.spoj.com/problems/AGGRCOW/
* https://www.geeksforgeeks.org/problems/aggressive-cows/0


Aggressive cows &rarr; max of (min distance between cows)

arr[] = [1 2 4 8], cows = 3


arr[] &emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 1 &emsp; 2 &emsp; 4 &emsp; 8

combination-1 &emsp; c1  &emsp; c2 &emsp; c3

(c1, c2) &rarr; 1; (c1, c3) &rarr; 3 ; (c2, c3) &rarr; 2  

min of all dist  &rarr; 1

if array is sorted, &rarr; no need to compare (c1, c3) when we are finding min

similarly other combinations possible, where can put cow at different indexes

after all combination, we need to find max of all combinations

Max ( comb-1, comb2, ...)


### Approach-1

arr[] = [0, 3, 4, 7, 9, 10] & cows = 4

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;0&emsp;&emsp;3&emsp;&emsp;4&emsp;&emsp;7&emsp;&emsp;9&emsp;&emsp;10

min dist. 1&emsp;C1&emsp;&ensp;C2&emsp;&ensp;C3&emsp;&ensp;C4

min dist. 2&emsp;C1&emsp;&ensp;C2&emsp;&emsp;&emsp;&emsp;&ensp;C3&emsp;C4

min dist. 3&emsp;C1&emsp;&ensp;C2&emsp;&emsp;&emsp;&emsp;&ensp;C3&emsp;&emsp;&emsp;&emsp;C4

min dist. 4&emsp;C1&emsp;&emsp;&emsp;&emsp;C2&emsp;&emsp;&emsp;&emsp;C3&emsp;&emsp;&emsp;&emsp;&rarr; unable to put C4, above 3 min dist among cows not possible

* why started from 0 index, bcz we want to put max cows 

min cows can possible is 2, so max distance if cows=2, in above example (10 - 0) &rarr; 10 


```java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
        
        int maxDist = stalls[n-1] - stalls[0];
        
        int result = -1;
        
        for(int i = 1; i <= maxDist; i++){
  
            if(isAssignmentPossible(stalls, i, k, n)){
                result = i;
            } else {
                break;
            }
        }
        
        return result;
    }
    
    private static boolean isAssignmentPossible(int[] stalls, int minDist, int cows, int n){
        
        int count = 1, lastAssigned = stalls[0];
        
        for(int i = 1; i < n; i++){
            
            if(stalls[i] - lastAssigned >= minDist){
                count++;
                lastAssigned = stalls[i];
            }
            
            if(count == cows){
                return true;
            }
            
        }
        
        return false;
    }
}
```

### Optimized above solution using binary search

```java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
        
        int minDist = 1, midDist;
        int maxDist = stalls[n-1] - stalls[0];
        
        int result = -1;
        
        while(minDist<=maxDist) {
            
            midDist = minDist + (maxDist - minDist)/2;
            
            if(isAssignmentPossible(stalls, midDist, k, n)){
                result = midDist;
                minDist = midDist + 1;
            } else {
                maxDist = midDist - 1;
            }
        }
        
        return result;
    }
    
    private static boolean isAssignmentPossible(int[] stalls, int minDist, int cows, int n){
        
        int count = 1, lastAssigned = stalls[0];
        
        for(int i = 1; i < n; i++){
            
            if(stalls[i] - lastAssigned >= minDist){
                count++;
                lastAssigned = stalls[i];
            }
            
            if(count == cows){
                return true;
            }
            
        }
        
        return false;
    }
}
```