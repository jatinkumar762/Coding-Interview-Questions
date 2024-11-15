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

