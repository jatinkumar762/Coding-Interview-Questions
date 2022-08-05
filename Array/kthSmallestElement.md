[Problem](https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1)

[Leetcode](https://leetcode.com/problems/kth-largest-element-in-an-array/)

#### Methods
* Sorting - O(NlogN)
* MinHeap - O(n + kLogn)
* MaxHeap -  O(k + (n-k)*Logk)
* QuickSort - Avg - O(N) - Worst - O(N^2)
* Randomized QuickSort - Avg - O(N)

```java
class Solution{
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static int pivotElement(int[] nums, int start,int end,int k){
        
        int ran_index = (int)(Math.random()*(end-start+1))+start;    
        swap(nums, ran_index, end);
        int pivot = start;
        for(int i=start;i<end;i++){
            if(nums[i]<nums[end]){
                swap(nums, pivot, i);
                pivot++;
            }
        }
        swap(nums, pivot, end);
        if(pivot==k)
            return nums[pivot];
        
        if(pivot<k)
            return pivotElement(nums, pivot+1, end, k);
        else
            return pivotElement(nums, start, pivot-1, k);
    }
    
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        int res = pivotElement(arr, l, r, k-1);
        //System.out.println(Arrays.toString(arr));
        return res;
    } 
}
```

[Editorial](https://www.cdn.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/)
