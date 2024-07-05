1. https://www.geeksforgeeks.org/problems/subset-sums2234/1

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