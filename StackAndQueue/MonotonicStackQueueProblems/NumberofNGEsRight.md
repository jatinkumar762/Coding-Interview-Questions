https://www.geeksforgeeks.org/problems/number-of-nges-to-the-right/1


#### Approach-1 Basic

```java
//User function Template for Java

class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
    
    int[] result = new int[queries];
    
    for(int i=0;i<queries;i++){
        int index = indices[i];
        int count = 0;
        for(int j = index+1;j<N;j++){
            if(arr[index] < arr[j]){
                count+=1;
            }
        }
        result[i] = count;
    }
    
    return result; 
  }
}
```

#### Approach-2 Optimized Approach -  Count Inversion(Merge Sort)

https://www.geeksforgeeks.org/number-nges-right/

```java
class Solution {
    
    //Note: The top level class cannot be static in java, to create a static class we must create a nested class and then make it static.
    static class Pair<K, V> {
        K first;
        V second;
        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        
        List<Pair<Integer, Integer>> vec = new ArrayList<>();
        //store the element along with their index
        for (int i = 0; i < N; i++) {
            vec.add(new Pair<>(arr[i], i));
        }
        
        //store the Number of NGEs to the right for every element
        int[] count = new int[N];
        
        countInv(vec, 0, N-1, count);
        
        int[] res = new int[queries];
        
        int q = 0;
        for(int ind : indices){
            res[q++] = count[ind];
        }
        
        return res;
    }
  
    private static void countInv(List<Pair<Integer, Integer>> vec, int l, int r, int[] ans) {
        if (l < r) {
            int m = l + (r - l)/2;
        
            // Recursively count inversions
            // in the left and right halves
            countInv(vec, l, m, ans);
            countInv(vec, m + 1, r, ans);
        
            // Count inversions such that greater element is in 
            // the left half and smaller in the right half
            countAndMerge(vec, l, m, r, ans);
        }
    }
  
    private static void countAndMerge(List<Pair<Integer, Integer>> vec, int l, int m, int r, int[] ans){
      
        // Counts in two subarrays
        int n1 = m - l + 1, n2 = r - m;
        
        // Set up two arrays for left and right halves
        List<Pair<Integer, Integer>> left = new ArrayList<>();
        List<Pair<Integer, Integer>> right = new ArrayList<>();

        for (int i = 0; i < n1; i++)
            left.add(vec.get(l + i));
        for (int j = 0; j < n2; j++)
            right.add(vec.get(m + 1 + j));
        
        //merge two halves
        int i = 0, j = 0, k = l;
        
        while (i < n1 && j < n2) {
        
            // No increment in inversion count
            // if left[] has a smaller or equal element
            if (left.get(i).first < right.get(j).first) {
                ans[left.get(i).second] += n2 - j;
                vec.set(k, left.get(i));
                k++;
                i++;
            }
            else {
                // If right is smaller, then it is smaller than n1-i 
                // elements because left[] is sorted
                vec.set(k, right.get(j));
                k++;
                j++;
            }
        }
        
        // Merge remaining elements
        while (i < n1){
            vec.set(k, left.get(i));
            k++;
            i++;
        }
        while (j < n2){
            vec.set(k, right.get(j));
            k++;
            j++;
        }
    }
}
```