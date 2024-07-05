1. https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
2. https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10

```java
class Solution {
    public int longestkSubstr(String S, int k) {
        // code here
        
        int longest = 0; 
        char[] charArr = S.toCharArray();
        Map<Character, Integer> uniqueChar = new HashMap<>();
        
        for(int i=0,j=0;j<charArr.length;j++){
            
            uniqueChar.put(charArr[j], uniqueChar.getOrDefault(charArr[j], 0)+1);
        
            while(uniqueChar.size()>k && i<=j){
                uniqueChar.put(charArr[i], uniqueChar.getOrDefault(charArr[i], 0)-1);
                if(uniqueChar.get(charArr[i])==0){
                    uniqueChar.remove(charArr[i]);
                }
                i++;
            }
            
            if(uniqueChar.size()==k){
                longest = Math.max(longest, j-i+1);
            } 
        }
        
        return longest==0?-1:longest;
    }
}
```