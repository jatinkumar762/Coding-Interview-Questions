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
class Solution {
    
    private ArrayList<Integer> result = new ArrayList<>();
    
    private void calSubSetSum(int index, ArrayList<Integer> arr, int n, int sum){
        
        if(index==n){
            result.add(sum);
            return;
        }
        
        //for(int i=index;i<n;i++){
        calSubSetSum(index+1, arr, n, sum + arr.get(index));
        
        calSubSetSum(index+1, arr, n, sum);
        //}
    }
    
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        calSubSetSum(0, arr, n, 0);
        return result;
    }
}
```
