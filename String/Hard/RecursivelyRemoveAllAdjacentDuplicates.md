[GFG-Recursively remove all adjacent duplicates](https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1)

#### Method-1: 
* Stackoverflow error will come on large input

```java
class Solution {
    //char last_removed; 
    
    static char last_removed; //will store the last char removed during recursion
   
    // Recursively removes adjacent duplicates from str and
    // returns new string. last_removed is a pointer to
    // last_removed character
 
    String rremove(String s) {
        
        last_removed = '\0';

        if(s.length()==0 || s.length()==1)
            return s;
        
        if(s.charAt(0)==s.charAt(1)){
            int j=1;
            last_removed = s.charAt(0);
            while(j<s.length() && s.charAt(0)==s.charAt(j)){
                j++;
            }
            if(j>=s.length())
                return "";
            String str = s.substring(j, s.length());
            return rremove(str);
        }
        
        char startChar = s.charAt(0);
        
        String remStr = rremove(s.substring(1, s.length()));
        
        if(remStr.length()>0 && startChar==remStr.charAt(0)){
            int j=0;
            last_removed = remStr.charAt(j);
            while(j<remStr.length() && startChar==remStr.charAt(j)){
                j++;
            }
            if(j>=remStr.length())
                return "";
            String str = remStr.substring(j, remStr.length());
            return str;
        }
        
        if(startChar==last_removed)
            return remStr;
            
        last_removed = '\0';
        return startChar + remStr;
    }
}
```

----

[leetcode - Easy - Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

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

[leetcode - Medium - Remove All Adjacent Duplicates in String II](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)

```java

```