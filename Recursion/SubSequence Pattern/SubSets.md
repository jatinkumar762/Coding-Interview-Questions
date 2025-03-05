https://leetcode.com/problems/subsets/description/

### Approach 1: Recursive

```java
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private int N;

    private void findAllSubSets(int index, int[] nums, List<Integer> tmp){

        if(index == N){
            result.add(new ArrayList<Integer>(tmp));
            return;
        }

        tmp.add(nums[index]);

        findAllSubSets(index+1, nums, tmp);

        tmp.remove(tmp.size()-1);

        findAllSubSets(index+1, nums, tmp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        N = nums.length;

        findAllSubSets(0, nums, new ArrayList<>());

        return result;
    }
}
```

**TimeComplexity:** $O(2^N)$ at each index we have 2 choices to take or not-take

**SpaceComplexity:** $O(N)$

### Approach 2: Recursive

```java
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int windowSize, N;
    
    public void generateAllSubSet(int[] nums, int start, List<Integer> tmp){

        if(tmp.size() == windowSize){
            //very imp to create new
            //otherwise balnk will create
            result.add(new ArrayList(tmp));
            return;
        }

        for(int i = start;i<N;i++){     
            tmp.add(nums[i]);
            generateAllSubSet(nums, i+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        N = nums.length;
        for(windowSize=0;windowSize<=nums.length;windowSize++) {
            generateAllSubSet(nums, 0, new ArrayList<>());
        }
        return result;
    }
}
```

TimeComplexity - O(N×2^N) to generate all subsets and then copy them into the output list.
Each element has 2 possibilities to take or not

#### Approach 3: Binary Representation of Numbers from 0 to 2^n – 1

```java
class Solution {

    public List<List<Integer>> subsets(int[] nums) {

         // Initialize the result list which will store all subsequences
        List<List<Integer>> result = new ArrayList<>();

        // Get the number of elements in the array
        int N = nums.length;

        // The total number of subsequences for an array of size N is 2^N
        // This is because for each element in the array, we have two choices: either include it in the subsequence or exclude it.
        int totalSubSequences = 1 << N;

        // Iterate through all possible subsequences (from 0 to 2^N - 1)
        for (int i = 0; i < totalSubSequences; i++) {
            
             // Temporary list to store the current subsequence
            List<Integer> tmp = new ArrayList<>();

            // For each bit position in i (from 0 to N-1), check if the bit is set
            for (int j = 0; j < N; j++) {

                // If the j-th bit of i is set, include nums[j] in the current subsequence
                if ((i & (1 << j)) != 0) {
                    tmp.add(nums[j]);
                }
            }

            // Add the current subsequence to the result list
            result.add(tmp);
        }

        // Return the list of all subsequences
        return result;
    }
}
```

**Time Complexity:** $O(N * 2^N)$

**Space Complexity:**

- The space complexity is also O(N * 2^N) since we store all the subsequences, and each subsequence can have at most N elements.

