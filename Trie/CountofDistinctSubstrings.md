https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1

#### Approach-1 TLE Solution

```java
class GfG
{
   public static int countDistinctSubstring(String st)
   {
       //your code here
       int len = st.length();    
       char[] charArr = st.toCharArray();
    
       Set<String> uniqStringSet = new HashSet<>();
       uniqStringSet.add("");
       
       for(int i=0;i<len;i++){
           String subStr = "";
           for(int j=i;j<len;j++){
               subStr += charArr[j];
               uniqStringSet.add(subStr);
           }
       }
       return uniqStringSet.size();
   }
}
```