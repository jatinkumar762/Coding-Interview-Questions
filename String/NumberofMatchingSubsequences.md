[Problem](https://leetcode.com/problems/number-of-matching-subsequences/)

```java
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        Map<Character, List<String>> bucket = new HashMap<>();
        
        for(Character ch : s.toCharArray()){
            bucket.put(ch, new ArrayList<String>());
        }
        
        for(String w : words){
            if(bucket.containsKey(w.charAt(0))){
                bucket.get(w.charAt(0)).add(w);
            }
        }
        
        int result = 0;
        for(Character ch : s.toCharArray())
        {
            if(bucket.containsKey(ch))
            {
                List<String> tmp = bucket.get(ch);
                bucket.put(ch, new ArrayList<String>());
                int index=0;
                for(String str : tmp)
                {
                    if(str.length()==1) {
                        result++;
                    }
                    else {
                        if(bucket.containsKey(str.charAt(1)))
                            bucket.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }  
        }
        return result;
    }
}
//Time Complexity -> s.length() + each word.length()
```
[Editorial](https://leetcode.com/problems/number-of-matching-subsequences/discuss/117634/Efficient-and-simple-go-through-words-in-parallel-with-explanation)