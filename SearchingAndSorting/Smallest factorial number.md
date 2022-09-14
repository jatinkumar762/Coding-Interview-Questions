[Smallest factorial number](https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1)

```java
class Solution
{
    int NoOfZeros(int num){
        
        int count=0;
        for(int i=5;(num/i)>=1;i*=5){
            count+=num/i;
        }
        return count;
    }
    
    int findNum(int n)
    {
        // Complete this function
        int low = 0;
        int high = n*5;
        int mid;
        while(low<high) {
            mid = (low+high)/2;
            int zeros = NoOfZeros(mid);
            if(zeros<n)
                low=mid+1;
            else
                high=mid;
        }
        return low;
    }
}
```