https://www.geeksforgeeks.org/problems/reverse-a-stack/1

```java
class Solution
{ 
    static void reverse_insert(Stack<Integer> s, int tmp){
        
        if(s.isEmpty()){
            s.push(tmp);
            return;
        }
        
        int top = s.pop();
        
        reverse_insert(s, tmp);
        
        s.push(top);
        
    }
    
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty() || s.size()==1){
            return;
        }
        
        int tmp = s.pop();
        
        reverse(s);
        
        reverse_insert(s, tmp);
    }
}
```