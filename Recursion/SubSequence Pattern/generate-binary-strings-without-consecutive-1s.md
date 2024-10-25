https://www.geeksforgeeks.org/problems/generate-all-binary-strings/0

### Approach-1 Recursion

```java
class Solution {
  
  public static List<String> generateBinaryStrings(int n) {
    // code here
    List<String> result = new ArrayList<>();
    
    findAllBinaryStrings(' ', 0 , n , "", result);
    
    return result;
  }
  
  private static void findAllBinaryStrings(char prevChar, int index, int n, String binaryStr, List<String> result){
      
      if(index == n){
        result.add(binaryStr);
        return;
      }
      
      if(prevChar==' ' || prevChar == '0'){
        findAllBinaryStrings('0', index + 1, n , binaryStr + "0", result);
        findAllBinaryStrings('1', index + 1, n , binaryStr + "1", result);
      } else {
        findAllBinaryStrings('0', index + 1, n , binaryStr + "0", result);  
      }
  }
  
}
```
