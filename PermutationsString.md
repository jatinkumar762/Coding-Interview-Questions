[Problem Link](https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1#)

```java
class Solution {
    
    static List<String> outputList;
    
    public void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public void printPermutations(char[] arr, int start, int end){
        
        if(start>=end){
            outputList.add(new String(arr));
            return;
        }
        
        for(int i=start;i<end;i++){
            swap(arr, start, i);
            printPermutations(arr, start+1, end);
            swap(arr, start, i);
        }
    }
    
    public List<String> find_permutation(String S) {
        // Code here
        outputList = new ArrayList<String>();
        char[] arr = S.toCharArray();
        printPermutations(arr, 0, arr.length);
        Collections.sort(outputList);
        return outputList;
    }
}
```

[Editorial](https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/)