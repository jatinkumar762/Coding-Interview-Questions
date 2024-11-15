1. https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
2. https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1


```java
class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<num;i++){
            
            minHeap.add(arr[i]);
            
            if(minHeap.size()>k){
                result.add(minHeap.poll());
            }
            
        }
        
        /*
          //Note here iterator will not work
          //this will give wrong result
          //bcz it will read in arbitrary order
          
          Iterator<Integer> itr = minHeap.iterator();
          while(itr.hasNext()){
              result.add(itr.next());
          }
        */
        
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        
        return result;
    }
}
```

