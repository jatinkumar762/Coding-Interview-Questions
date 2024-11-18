https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

### Approach-1 Concatenate all and Sort

### Approach-2 Using Min Heap

```java
class Solution
{
    static class Element {
        int val;
        int arrayIndex;
        int elementIndex;
        
        public Element(int v, int ai, int ei){
            this.val = v;
            this.arrayIndex = ai;
            this.elementIndex = ei;
        }
    }
    
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        
        //min heap
        PriorityQueue<Element> pq = new PriorityQueue<>( (a, b) -> a.val - b.val);
        
        //first min will be present among first element of each arr
        //heap size will be max K
        for(int i = 0; i < K; i++){
            pq.add(new Element(arr[i][0], i, 0));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int N = arr[0].length;
        
        while(!pq.isEmpty()){
            
            Element ele = pq.poll();
            
            result.add(ele.val);
            
            if((ele.elementIndex + 1) < N){
                pq.add(new Element(arr[ele.arrayIndex][ele.elementIndex + 1], ele.arrayIndex, ele.elementIndex + 1));
            }
            
        }
        
        return result;
    }
}
```

**Time Complexity:**

* $O(NlogK)$, where $𝑁$ is the total number of elements across all arrays and $K$ is the number of arrays. Each element insertion and extraction from the heap takes 
$𝑂(log𝐾)$, and there are $𝑁$ elements in total.

**Space Complexity:**

* $O(K)$ for the min-heap, as it holds at most one element from each array at any given time.


### Approach-3 Divide and Conquer technique

```java
class Solution
{
    //Function to merge k sorted arrays.
    public ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        
        ArrayList<ArrayList<Integer>> inputList = new ArrayList<>();
        
        for(int i = 0; i < K; i++){
            
            ArrayList<Integer> tmp = new ArrayList<>();
            
            for(int ele : arr[i]){
                tmp.add(ele);
            }
            
            inputList.add(tmp);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        result = mergeSort(inputList, 0, K-1);
        
        return result;
    }
    
    private ArrayList<Integer> mergeSort(ArrayList<ArrayList<Integer>> inputList, int low, int high){
        
        if(low == high){
            return inputList.get(low);
        }
        
        if(high - low == 1) {
            return merge(inputList.get(low), inputList.get(high));
        }
        
        //if(low < high){
            
        int mid = low + (high - low)/2;
        
        ArrayList<Integer> list1 = mergeSort(inputList, low, mid);
        
        ArrayList<Integer> list2 = mergeSort(inputList, mid+1, high);
        
        return merge(list1, list2);
        //}
    }
    
    
    private ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        
        int n1 = list1.size();
        
        int n2 = list2.size();
        
        if(n1 == 0){
            return list2;
        }
        
        if(n2 == 0){
            return list1;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < n1 && j < n2){
            
            if(list1.get(i) <= list2.get(j)){
                result.add(list1.get(i));
                i++;
            }
            else {
                result.add(list2.get(j));
                j++;
            }
        }
        
        while(i < n1){
            result.add(list1.get(i));
            i++;
        }
        
        while(j < n2){
            result.add(list2.get(j));
            j++;
        }
        
        return result;
    }
    
}
```



