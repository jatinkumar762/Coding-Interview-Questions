[Smallest distinct window](https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1)

```java
class Solution {
    public int findSubString( String str) {
        // Your code goes here
        if(str.length()==1)
            return 1;
        
        int[] freq = new int[256];
        
        Set<Character> uniq = new HashSet<>();
        for(int i=0;i<str.length();i++)
            uniq.add(str.charAt(i));
        
        int count = uniq.size();
        
        int start=0,end=1;
        freq[str.charAt(start)]++;
        int distinct=1;
        
        //System.out.println(count);
        
        int min = Integer.MAX_VALUE;
        while(end<str.length() && start<end){
            
            if(freq[str.charAt(end)]==0){
                distinct++;
            }
            freq[str.charAt(end)]++;
            
            while(distinct==count && start<end){
                if(freq[str.charAt(start)]-1!=0){
                    freq[str.charAt(start)]--;
                    start++;
                }
                else{
                    if(min>(end-start+1))
                        min = end-start+1;
                    break;
                }
                if(min>(end-start+1))
                    min = end-start+1;
            }
            
            end++;
        }
        return min;
    }
}
```

#### Editorial
* [https://www.geeksforgeeks.org/smallest-window-contains-characters-string/](https://www.geeksforgeeks.org/smallest-window-contains-characters-string/)