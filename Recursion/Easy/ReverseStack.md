https://www.geeksforgeeks.org/problems/reverse-a-stack/1

```java
class Solution
{ 
    static void reverse_insert(Stack<Integer> s, int tmp){
        
        //will make recursive call until stack empty
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

        if(s.isEmpty() || s.size()==1){
            return;
        }
        
        int tmp = s.pop();
        
        reverse(s);
        
        reverse_insert(s, tmp);
    }
}
```

stack &rarr; [3, 4, 5]

3, [4, 5] &rarr; 4, [5] &rarr; 5

[5, 4, 3] &larr; [5, 4] &larr; 5
