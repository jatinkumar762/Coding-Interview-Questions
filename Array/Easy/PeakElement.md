[Problem](https://practice.geeksforgeeks.org/problems/peak-element/1)

```java
class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int findPeak(int[] arr,int start,int end){
        
        if(start==end)
            return start;
    
        if(start+1==end){
            return arr[start]>arr[end]?start:end;
        }
        
        int mid = start + (end-start)/2;
        
        if(arr[mid]>=arr[mid-1]&&arr[mid]>=arr[mid+1])
            return mid;
        
        if(arr[mid]<arr[mid+1])
            return findPeak(arr, mid+1, end);
        
        return findPeak(arr, start, mid-1);
        	    
	}
	
	public int peakElement(int[] arr,int n)
    {
       //add code here.
        return findPeak(arr, 0, n-1);
    }
}
```