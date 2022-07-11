[Problem](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

#### Method-1: Stack
```java
class Solution {
    public String removeDuplicates(String s) {
        
        if(s.length()==1)
            return s;
        
        char[] arr = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<Character>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(stack.size()>0 && arr[i]==stack.peek()){
                stack.poll();
            }
            else{
                stack.push(arr[i]);
            }
        }
        StringBuilder output = new StringBuilder("");
        for(Character ch : stack){
            output.append(ch);
        }
        return new String(output.reverse());
    }
}
```
#### Stack solution of leetcode

```java
public String removeDuplicates(String S) {
    StringBuilder sb = new StringBuilder();
    for (char c : S.toCharArray()) {
        int size = sb.length();
        if (size > 0 && sb.charAt(size - 1) == c) {
            sb.deleteCharAt(size - 1);
        } else {
            sb.append(c);
        }
    }
    return sb.toString();
}
```