[GFG](https://practice.geeksforgeeks.org/problems/print-anagrams-together/1)

[Leetcode](https://leetcode.com/problems/group-anagrams/)

#### Time limit Exceed on leetcode
* keep boolean array of already visited word

```java
class Solution {
    
    public boolean checkAnagram(String str1, String str2){
        
        if(str1.length()!=str2.length())
            return false;
            
        int[] freq = new int[256];
        Arrays.fill(freq,0);
        
        for(int i=0;i<str1.length();i++){
            freq[str1.charAt(i)]++;
        }
        
        for(int i=0;i<str2.length();i++){
            freq[str2.charAt(i)]--;
        }
        
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0)  return false;
        }
        return true;
    }
    
    public List<List<String>> groupAnagrams(String[] string_list) {
        boolean[] visited = new boolean[string_list.length];
        
        List<List<String>> result = new ArrayList<>();
        
        for(int i=0;i<string_list.length;i++){
            if(visited[i]){
               continue; 
            } else {
                visited[i] = true;
                
                List<String> subResult = new ArrayList<>();
                subResult.add(string_list[i]);
                
                for(int j=i+1;j<string_list.length;j++){
                    if(!visited[j] && checkAnagram(string_list[i], string_list[j])){
                        visited[j] = true;
                        subResult.add(string_list[j]);
                    }
                }
                result.add(subResult);
            }
        }
        return result;
    }
}
```

#### Non TLE Solution

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String keyStr = String.valueOf(ca);
        if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
        map.get(keyStr).add(s);
    }
    return new ArrayList<>(map.values());
}
```

Instead of sorting, we can also build the key string in this way.

```java
public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] ca = new char[26];
        for (char c : s.toCharArray()) ca[c - 'a']++;
        String keyStr = String.valueOf(ca);
        if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
        map.get(keyStr).add(s);
    }
    return new ArrayList<>(map.values());
}
```