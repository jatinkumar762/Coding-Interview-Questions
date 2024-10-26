https://www.geeksforgeeks.org/problems/better-string/1

### Approach-1 

* will give TLE

```java
class Solution {
    public static String betterString(String str1, String str2) {
        // Code here
        
        int c1 = countDistinctSubSequences(str1);
        int c2 = countDistinctSubSequences(str2);
        
        return c1 >= c2 ? str1 : str2;
        
    }
    
    private static int countDistinctSubSequences(String str){
        
        Set<String> distStrings = new HashSet<>();
        
        int N = str.length();

        // 2^N
        int totalSubSequences = 1 << N;

        for (int i = 0; i < totalSubSequences; i++) {

            StringBuilder tmp = new StringBuilder("");

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    tmp.append(str.charAt(j));
                }
            }

            distStrings.add(tmp.toString());
        }
        
        return distStrings.size();
    }
}
```