https://leetcode.com/problems/valid-parenthesis-string/description/

#### Approach 1: Using Two Stacks

```java
class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> openBracketIndexStack = new Stack<>();
        Stack<Integer> asterisksIndexStack = new Stack<>();

        int index = 0;
        for(Character c:s.toCharArray()){

            if(c=='('){
                openBracketIndexStack.add(index);

            } else if(c==')'){

                if(openBracketIndexStack.size()>0){
                    openBracketIndexStack.pop();
                } else if(asterisksIndexStack.size()>0){
                    asterisksIndexStack.pop();
                } else return false;

            } else if(c=='*'){
                asterisksIndexStack.add(index);
            }

            index+=1;
        }

        //if(openBracketIndexStack.size()>asterisksIndexStack.size()) return false;

        while(!openBracketIndexStack.isEmpty() && !asterisksIndexStack.isEmpty()){
            if(openBracketIndexStack.pop()>asterisksIndexStack.pop()){
                return false;
            }
        }

        return openBracketIndexStack.isEmpty();
    }
}
```