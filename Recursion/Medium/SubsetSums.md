1. https://www.geeksforgeeks.org/problems/subset-sums2234/1

### Approach-1 Bit Manipulation

```java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        
        int resultCount = (1<<n);
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<resultCount;i++){
            int sum=0;
            for(int j=0;j<n;j++){
              if((i & (1<<j)) !=0){
                sum+=arr.get(j);
              }    
            }
            result.add(sum);
        }
        
        return result;
    }
}
```

### Approach-2 Using Recursion

```java
void subSetSumHelper(int index, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> subSetSum){
        
    if(index==N){
        subSetSum.add(sum);
        return;
    }
    
    subSetSumHelper(index+1, sum+arr.get(index), arr, N, subSetSum);
    
    subSetSumHelper(index+1, sum, arr, N, subSetSum);
}

ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
    // code here
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    subSetSumHelper(0, 0, arr, n, result);
    
    return result;
}
```
