https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/

```java
class ItemComparator implements Comparator<Item> {
    
    public int compare(Item a, Item b){
        
        double aVW = (double)a.value/(double)a.weight;
        double bVW = (double)b.value/(double)b.weight;
        
        if(aVW<bVW){
            return 1;
        } else if(aVW>bVW){
            return -1;
        }
        return 0;
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        
        Arrays.sort(arr, new ItemComparator());
        double result = 0;
        
        for(int i=0;i<n && w>0;i++){
         if(arr[i].weight<=w){
             w-=arr[i].weight;
             result+=arr[i].value;
         } else {
             result+= (((double)arr[i].value/arr[i].weight)*w);
             break;
         }
        }
        
        return result;
    }
}
```