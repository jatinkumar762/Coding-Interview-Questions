[Problem](https://practice.geeksforgeeks.org/problems/next-permutation5226/1#)

```java
class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        List<Integer> result = new ArrayList<Integer>();
        
        if(arr.length>1)
        {
            int i,j;
            for(i=arr.length-2;i>=0;i--){
                if(arr[i]<arr[i+1])
                    break;
            }
            if(i<0){
                Arrays.sort(arr);
            }
            else{
                
                int maxIndex = i+1;
                for(j=i+1;j<arr.length;j++){
                    if(arr[j]>arr[i] && arr[j]<arr[maxIndex]){
                        maxIndex=j;
                    }
                }
                
                Integer tmp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = tmp;
                
                Arrays.sort(arr, i+1, arr.length);
            }
        }
        for(Integer ele : arr){
            result.add(ele);
        }
        return result;
    }
}
```