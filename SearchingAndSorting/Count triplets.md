[Count triplets with sum smaller than X](https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1)

```java
class Solution
{
    long countTriplets(long arr[], int n,int sum) {
        Arrays.sort(arr);
        int i,j,k;
        long ans = 0L;
        for(k=n-1;k>=2;k--){
            i=0;j=k-1;
            while(i<j){
                if(arr[i]+arr[j]+arr[k]>=sum){
                    j--;
                } else {
                    //for i and k, these total combination there
                    //if i small elment added with another elment which is less than highest
                    //will remain sum total less 
                    ans += (j-i);
                    i++;
                }
            }
        }
        return ans;
    }
}
```
