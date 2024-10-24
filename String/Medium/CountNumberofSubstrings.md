https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1

### Problem - Distinct Unique Substrings 

```java
import java.util.HashSet;
import java.util.Set;

public class UniqueSubstrings {
    public static void main(String[] args) {
        String input = "abc";
        int uniqueCount = countUniqueSubstrings(input);
        System.out.println("Number of unique substrings: " + uniqueCount);
    }

    public static int countUniqueSubstrings(String str) {
        Set<String> uniqueSubstrings = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                // Add the substring from index i to j
                uniqueSubstrings.add(str.substring(i, j));
            }
        }

        return uniqueSubstrings.size();
    }
}
```

### count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

```java
class Solution
{
    long substrCount (String S, int K) {
        // your code here
        return countAtMostKDistinct(S, K) - countAtMostKDistinct(S, K-1);
    }
    
    private long countAtMostKDistinct(String S, int k){
        
        int left = 0;
        int right = 0;
        
        int len = S.length();
        
        int count = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        
        for(; right < len; right++){
            
            char ch = S.charAt(right);
            
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
            
            // When we have more than k distinct characters, shrink from the left
            while(charCount.size() > k){
                charCount.put(S.charAt(left), charCount.get(S.charAt(left)) - 1);
                
                if(charCount.get(S.charAt(left)) == 0){
                    charCount.remove(S.charAt(left));
                }    
                
                left++;
            }
            
            //str - aba, k = 2
            //a         - 1     L = 0, R = 0
            //b ab      - 2     L = 0, R = 1
            //a ba aba  - 3     L = 0, R = 2
            // total    - 6
            count += right - left + 1;
        }
        
        return count;
    }
}
```
