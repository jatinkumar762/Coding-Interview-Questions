[First and last occurrences of x](https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1)

```java
class GFG
{
    int left,right;
    
    int findFirst(long arr[],int low,int high,int x){
        int mid;
        while(low<=high){
            if(arr[low]==x)
               return low;
            mid = (low+high)/2;
            if(arr[mid]==x && (mid==low || arr[mid-1]!=x))
                return mid;
            if(arr[mid]>=x)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    
    int findLast(long arr[],int low,int high,int x){
        int mid;
        while(low<=high){
            if(arr[high]==x)
                return high;
            mid = (low+high)/2;
            if(arr[mid]==x && (mid==high || arr[mid+1]!=x))
                return mid;
            if(arr[mid]>x)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    
    int BinarySearchL(long arr[],int low,int high,int x){
        
        if(low>high)
            return -1;
        
        int mid = (low+high)/2;
        
        if(arr[low]==x)
            return low;
            
        if(arr[mid]==x && (mid==low || arr[mid-1]!=x))
            return mid;
        
        if(arr[mid]>=x)
            return BinarySearchL(arr,low, mid-1, x);
        else
            return BinarySearchL(arr,mid+1, high, x);
    }
    
    int BinarySearchR(long arr[],int low,int high,int x){
        
        if(low>high)
            return -1;
            
        int mid = (low+high)/2;
        
        if(arr[high]==x)
            return high;
            
        if(arr[mid]==x && (mid==high || arr[mid+1]!=x))
            return mid;
        
        if(arr[mid]>x)
            return BinarySearchR(arr,low, mid-1, x);
        else
            return BinarySearchR(arr,mid+1, high, x);
    }
    
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        left = BinarySearchL(arr, 0, n-1, x);
        right = BinarySearchR(arr, 0, n-1, x);
        
        //left = findFirst(arr, 0, n-1, x);
        //right = findLast(arr, 0, n-1, x);
        
        ArrayList<Long> result = new ArrayList<Long>();
        result.add((long)left);
        result.add((long)right);
        return result;
    }
}
```