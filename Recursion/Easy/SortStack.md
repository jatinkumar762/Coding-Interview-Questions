https://www.geeksforgeeks.org/problems/sort-a-stack/1


```java
class GfG {
    
    private void sort_insert(Stack<Integer> s, int tmp){
        
        //stack is empty or current element > stack top
        //push on top
        if(s.isEmpty() || s.peek() < tmp){
            s.push(tmp);
            return;
        }
        
        //stack top greater than current element
        int top = s.pop();
        
        sort_insert(s, tmp);
        
        //highest element pushed on top
        s.push(top);
    }
    
    
    public Stack<Integer> sort(Stack<Integer> s) {
        
        //base condition
        if(s.isEmpty() || s.size()==1){
            return s;
        }

        // taking out top element from stack
        int tmp = s.pop(); 
        
        //recursive call after removing top
        sort(s);

        //will add now extracted top in sorted stack
        sort_insert(s, tmp);
        
        return s;
    }
}
```