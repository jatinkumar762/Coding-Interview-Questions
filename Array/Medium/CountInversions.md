[Problem](https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1)

```java
class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long merge(long arr[],int low,int mid,int end){
        int n1 = mid - low + 1;
        int n2 = end - mid;
        
        long[] arr1 = new long[n1];
        long[] arr2 = new long[n2];
        
        for(int i=0;i<n1;i++){
            arr1[i] = arr[low+i];
        }
        for(int i=0;i<n2;i++){
            arr2[i] = arr[mid+1+i];
        }
        
        long inversionCount = 0L;
        int k=low,i=0,j=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                arr[k++]=arr1[i++];
            }
            else{
                arr[k++]=arr2[j++];
                inversionCount += (mid+1-(low+i));
            }
        }
        while(i<n1){
            arr[k++]=arr1[i++];
        }
        while(j<n2){
            arr[k++]=arr2[j++];
        }
        return inversionCount;
    }
    
    static long mergeSort(long arr[], int low,int end){
        long res = 0L; 
        if(low<end){
            int mid = (low+end)/2;
            res += mergeSort(arr, low, mid);
            res += mergeSort(arr, mid+1, end);
            res += merge(arr, low, mid, end);
        }
        return res;
    }
    
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long res = mergeSort(arr, 0, arr.length-1);
        return res;
    }
}
```

#### Editorial
* [https://www.techiedelight.com/inversion-count-array/](https://www.techiedelight.com/inversion-count-array/)