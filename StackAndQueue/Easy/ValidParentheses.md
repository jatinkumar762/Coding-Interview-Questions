[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

```java
class Solution 
{
    public boolean isValid(String s) 
    {
        
            int len=s.length();
	        
            if(len%2!=0)
                return false;
            
	        char ch[]=s.toCharArray();
	        char stack[]=new char[len];
	        int top=-1;
	        int i=0;
	        boolean flag=false;
            for(i=0;i<len;i++)
            {
                flag=false;
                switch(ch[i])
                {
                    case '{':stack[++top]=ch[i];
                             break;
                    case '[':stack[++top]=ch[i];
                            break;
                    case '(':stack[++top]=ch[i];
                            break;
                    case '}':if(top<0 || (top>=0 && stack[top]!='{')){flag=true;}
                             --top; break;
                    case ']':if(top<0 || (top>=0 && stack[top]!='[')){flag=true;}
                            --top; break;
                    case ')':if(top<0 || (top>=0 && stack[top]!='(')){flag=true;}
                            --top; break;
                }
                if(flag)
                    break;
            }
	        
	        if(top==-1 && i==len)
	            return true;
	        else
	            return false;
        
    }
}
```

### Approach-2 Using Stack library

```java
class Solution {
    public boolean isValid(String s) {

        int len = s.length();

        if (len % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char pop = stack.pop();

            if (!match(pop, ch)) {
                return false;
            }
        }

        return stack.isEmpty() ? true : false;
    }

    private boolean match(char c1, char c2) {

        switch (c1) {
            case '{' -> {
                return c2 == '}' ? true : false;
            }
            case '(' -> {
                return c2 == ')' ? true : false;
            }
            case '[' -> {
                return c2 == ']' ? true : false;
            }
        }

        return false;
    }
}
```

### Approach-3 100% faster

```java
class Solution {
    public boolean isValid(String s) {

        int len = s.length();

        if (len % 2 != 0)
            return false;

        int i = -1;

        char[] stack = new char[len];

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++i] = ch;
            } else {
                if (i >= 0
                        && ((stack[i] == '(' && ch == ')')
                                || (stack[i] == '{' && ch == '}')
                                || (stack[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }
}
```