[Problem Link](https://leetcode.com/problems/shuffle-string/)

```java

class Solution {
    public String restoreString(String s, int[] indices) {
        
        char[] input = s.toCharArray();
        int i=0;
        
        while(i<indices.length){
            
            if(indices[i] != i){
                
                int index = indices[i];
                
                char swapC = input[i];
                input[i] = input[index];
                input[index] = swapC;
                
                int swapIndex = indices[i];
                indices[i] = indices[index];
                indices[index] = swapIndex;
            
            }
            else
                i++;
            
        }
        return new String(input);
    }
}


```