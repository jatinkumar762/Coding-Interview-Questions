[Problem Link](https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1)

```java
class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        if(str1.length()!=str2.length())
            return false;
            
        // Your code here
        Map<Character, Character> mapping = new HashMap<Character, Character>();
        
        boolean[] visited = new boolean[256];
        Arrays.fill(visited, false);
        
        for(int i=0;i<str1.length();i++) {
            
            if(mapping.containsKey(str1.charAt(i))) {
                if(str2.charAt(i) != mapping.get(str1.charAt(i)))
                    return false;
            }
            else {
                
                if(visited[str2.charAt(i)]) {
                    
                    return false;
                }
                else {
                    
                    mapping.put(str1.charAt(i), str2.charAt(i));
                    visited[str2.charAt(i)] = true;
                }
            }
        }
        return true;
    }
}
```
