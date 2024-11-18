https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1

```java
class Solution {
    void convertMinToMaxHeap(int N, int arr[]) {
    // code here
        
        for(int i = parent(N); i>=0; i--){
            maxHeapify(i, arr, N);
        }
        
    }
    
    private void maxHeapify(int index, int arr[], int N){
        
        int max = index;
        int l = left(index);
        int r = right(index);
        
        if(l < N && arr[max] < arr[l]){
            max = l;
        }
        
        if(r < N && arr[max] < arr[r]){
            max = r;
        }
        
        if(index!=max){
            swap(arr, index, max);
            maxHeapify(max, arr, N);
        }
    }
    
    private int parent(int i){
        return (i-1)/2;
    }
    
    private int left(int i){
        return 2*i + 1;
    }
    
    private int right(int i){
        return 2*i + 2;
    }
    
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```