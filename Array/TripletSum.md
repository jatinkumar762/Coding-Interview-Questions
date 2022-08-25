[Problem](https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1)

```java
class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
    
       // Your code Here 
        Arrays.sort(A);
        for(int i=n-1;i>=0;i--){
            if(A[i]>=X)
                continue;
            
            int target = X - A[i];
            int j=0,k=i-1;
            while(j<k){
                if(A[j]+A[k]==target)
                    return true;
                else if(A[j]+A[k]>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return false;
    }
}
```


