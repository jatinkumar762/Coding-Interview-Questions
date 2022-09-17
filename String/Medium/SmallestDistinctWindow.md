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


----

[Smallest window in a string containing all the characters of another string](https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1)

```java
class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    final static int TOTAL_CHARS = 256;
    
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int s_len = s.length();
        int p_len = p.length();
        
        int[] hashStr = new int[TOTAL_CHARS];
        int[] hashPatt = new int[TOTAL_CHARS];
        
        Arrays.fill(hashStr,0);
        Arrays.fill(hashPatt,0);
        
        for(int i=0;i<p.length();i++){
            hashPatt[p.charAt(i)]++;
        }
        
        int count=0,start=0,end=0;
        int min_len = Integer.MAX_VALUE;
        int start_index = -1;
        
        for(end=0;end<s.length();){
            
            hashStr[s.charAt(end)]++;
            
            if(hashPatt[s.charAt(end)]!=0 && hashStr[s.charAt(end)]<=hashPatt[s.charAt(end)]){
                count++;
            }
            
            if(count==p_len)
            {
                while(hashStr[s.charAt(start)]>hashPatt[s.charAt(start)] || hashStr[s.charAt(start)]==0)
                {
                    if(hashStr[s.charAt(start)]>hashPatt[s.charAt(start)]){
                        hashStr[s.charAt(start)]--;
                    }
                    start++;
                } 
                
                if(min_len>(end-start+1)){
                    min_len=end-start+1;
                    start_index = start;
                }
            }
            end++;
        }
        
        if(start_index==-1)
            return "-1";
        
        return s.substring(start_index, start_index+min_len);
    }
}
```

#### Editorial
* [https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/](https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/)

