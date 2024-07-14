https://www.geeksforgeeks.org/problems/sort-a-stack/1

```java
class GfG {
    
    private void sort_insert(Stack<Integer> s, int tmp){
        
        if(s.isEmpty() || s.peek() < tmp){
            s.push(tmp);
            return;
        }
        
        int top = s.pop();
        
        sort_insert(s, tmp);
        
        s.push(top);
    }
    
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        
        if(s.isEmpty() || s.size()==1){
            return s;
        }
        
        int tmp = s.pop();
        
        sort(s);
        
        sort_insert(s, tmp);
        
        return s;
    }
}
```